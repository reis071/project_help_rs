package com.example.demo.services.cd;


import com.example.demo.Exceptions.cd.CdException;
import com.example.demo.daos.abrigo.AbrigoDAO;
import com.example.demo.daos.cd.CdDAO;
import com.example.demo.daos.pedido.PedidoDAO;
import com.example.demo.daos.produtos.ProdutosDAO;
import com.example.demo.dto.cd.CdDTO;
import com.example.demo.dto.pedido.PedidoDTO;
import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.cd.Cd;

import com.example.demo.models.pedido.Pedido;
import com.example.demo.models.produtos.Produtos;
import com.example.demo.repositories.produtos.ProdutosRP;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.UUID;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class CdService {

    private final CdDAO cdDAO;

    private final ProdutosDAO produtosDAO;
    private final PedidoDAO pedidoDAO;
    private final AbrigoDAO abrigoDAO;

    private static final Logger logger = LoggerFactory.getLogger(CdService.class);

    public CdDTO registrarCd(Cd cd) {
        cdDAO.registrarCd(cd);
        return new CdDTO(cd);
    }

    public CdDTO buscarCd(String nomeCd) {
        return new CdDTO( cdDAO.buscarCd(nomeCd) );
    }

    public Pedido buscarPedido(UUID id) {
        return pedidoDAO.buscarPedido(id);
    }


    public Produtos cadastrarProdutosCd(Produtos produtos) {
        Cd cd = cdDAO.buscarCd(produtos.getCd().getNome());

        cd.getProdutos().add(produtos);

        produtos.setCd(cd);

        return produtosDAO.cadastrarProduto(produtos);
    }


    public List<PedidoDTO> visualizarPedido(String nomeCd) {

        Cd cd = cdDAO.buscarCd(nomeCd);


        List<Pedido> pedidos = pedidoDAO.statusPedido(cd);

        return pedidos.stream()
                .map(PedidoDTO::new)
                .collect(Collectors.toList());
    }


    public String aceitarPedido(UUID id) {
        Pedido pedido = buscarPedido(id);

        Cd cd = cdDAO.buscarCd(pedido.getPara().getNome());


        cd.getProdutos().forEach(produto -> {
            if (produto.getDescricao().equals(pedido.getProduto())) {
                if (produto.getQuantidadeDisponivel() < pedido.getQuantidade()) {
                    throw new CdException("Quantidade disponível insuficiente no Centro De Distribuição.");
                }
                produto.setQuantidadeDisponivel(produto.getQuantidadeDisponivel() - pedido.getQuantidade());
            }
        });

        Abrigo abrigo = abrigoDAO.buscarAbrigoDetails(pedido.getDe().getNome());


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
            abrigo.getProdutos().add(novoProduto);

            produtosDAO.cadastrarProduto(novoProduto);
        }

        pedido.setStatus("Aprovado");
        cdDAO.registrarCd(cd);
        abrigoDAO.cadastrarAbrigo(abrigo);
        pedidoDAO.cadastrarPedido(pedido);

        return "Pedido aprovado";
    }

    public String negarPedido (UUID id, String MotivoCancelamento){
            Pedido pedido = buscarPedido(id);

            if (!pedido.getStatus().equals("Aprovado")) {
                pedido.setStatus("Negado");
                pedido.setMotivoCancelamento(MotivoCancelamento);

                pedidoDAO.cadastrarPedido(pedido);
                return "Pedido Cancelado";
            }

            return "Este pedido ja foi decretado";
        }

    }
