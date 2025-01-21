package com.example.demo.services.abrigo;

import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.cd.Cd;
import com.example.demo.models.pedido.Pedido;
import com.example.demo.repositories.abrigo.AbrigoRP;

import com.example.demo.repositories.pedido.PedidoRP;
import com.example.demo.services.cd.CdService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AbrigoService {

    private final AbrigoRP abrigoRP;
    private final PedidoRP pedidoRP;

    private final CdService cdService;

    @Transactional
    public Abrigo registrarAbrigo(Abrigo abrigo) {
        return abrigoRP.save(abrigo);
    }

    @Transactional
    public Pedido fazerPedido( Pedido pedido) {

        Cd cd = cdService.buscarCd(pedido.getPara().getNome());

        Abrigo abrigo = abrigoRP.findByNome(pedido.getDe().getNome());
        if (abrigo == null) {
            throw new RuntimeException("Abrigo não encontrado");
        }

        Hibernate.initialize(abrigo.getProdutos());

        Pedido pedidoNovo = new Pedido(pedido.getProduto(),pedido.getQuantidade(),
                cd,abrigo);

        return pedidoRP.save(pedidoNovo);

    }
}
