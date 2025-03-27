package com.example.demo.daos.pedido;

import com.example.demo.Exceptions.pedido.PedidoException;
import com.example.demo.models.cd.Cd;
import com.example.demo.models.pedido.Pedido;
import com.example.demo.repositories.pedido.PedidoRP;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class PedidoDAO {

    private final PedidoRP pedidoRP;

    @Transactional
    public Pedido cadastrarPedido(Pedido pedido) {
        return pedidoRP.save(pedido);
    }

    @Transactional
    public Pedido buscarPedido(UUID id) {
        return pedidoRP.findById(id).orElseThrow(() -> new PedidoException("Pedido nao encontrado"));
    }

    @Transactional
    public List<Pedido> statusPedido(Cd cd) {
        return pedidoRP.findStatus(cd);
    }
}
