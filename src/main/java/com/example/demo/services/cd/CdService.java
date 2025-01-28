package com.example.demo.services.cd;


import com.example.demo.dto.cd.CdDTO;
import com.example.demo.dto.pedido.PedidoDTO;
import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.cd.Cd;

import com.example.demo.models.pedido.Pedido;
import com.example.demo.models.produtos.Produtos;
import com.example.demo.repositories.abrigo.AbrigoRP;
import com.example.demo.repositories.pedido.PedidoRP;
import com.example.demo.repositories.produtos.ProdutosRP;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.cd.CdRp;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class CdService {

    private final CdRp cdRP;
    private final ProdutosRP produtosRP;
    private final PedidoRP pedidoRP;
    private final AbrigoRP abrigoRP;


    public CdDTO registrarCd(Cd cd) {
         cdRP.save(cd);

        return new CdDTO(cd);
    }

    @Transactional
    public Cd buscarCd(String nomeCd){

        Cd cd = cdRP.findByNome(nomeCd);

        Hibernate.initialize(cd.getProdutos());

        return cd;
    }

    @Transactional
    public Produtos cadastrarProdutosCd(Produtos produtos) {
        Cd cd = cdRP.findByNome(produtos.getCd().getNome());

        cd.getProdutos().add(produtos);
        produtos.setCd(cd);
        return produtosRP.save(produtos);
    }


    @Transactional
    public List<PedidoDTO> visualizarPedido(String nomeCd) {

        Cd cd = cdRP.findByNome(nomeCd);


        List<Pedido> pedidos = pedidoRP.findStatus(cd);

        return pedidos.stream()
                .map(PedidoDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public String aceitarPedido(UUID id) {
        Pedido pedido = pedidoRP.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Cd cd = cdRP.findByNome(pedido.getPara().getNome());


        cd.getProdutos().forEach(produto -> {
            if (produto.getDescricao().equals(pedido.getProduto())) {
                if (produto.getQuantidadeDisponivel() < pedido.getQuantidade()) {
                    throw new RuntimeException("Quantidade disponível insuficiente no CD.");
                }
                produto.setQuantidadeDisponivel(produto.getQuantidadeDisponivel() - pedido.getQuantidade());
            }
        });


        Abrigo abrigo = abrigoRP.findByNome(pedido.getDe().getNome());


        Produtos produtoNoAbrigo = abrigo.getProdutos().stream()
                .filter(p -> p.getDescricao().equals(pedido.getProduto()))
                .findFirst()
                .orElse(null);

        if (produtoNoAbrigo != null) {
            produtoNoAbrigo.setQuantidadeDisponivel(produtoNoAbrigo.getQuantidadeDisponivel() + pedido.getQuantidade());
        } else {
            Produtos novoProduto = new Produtos();
            novoProduto.setDescricao(pedido.getProduto());
            novoProduto.setQuantidadeDisponivel(pedido.getQuantidade());


            novoProduto = produtosRP.save(novoProduto);

            abrigo.getProdutos().add(novoProduto);
        }


        cdRP.save(cd);
        abrigoRP.save(abrigo);


        pedido.setStatus("Aprovado");
        pedidoRP.save(pedido);

        return "Pedido aprovado";
    }

    @Transactional
    public String recusarPedido(UUID id) {
        Pedido pedido = pedidoRP.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));

        pedido.setStatus("Recusado");

        pedidoRP.save(pedido);

        return "Pedido recusado";

    }
}
