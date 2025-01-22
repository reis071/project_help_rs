package com.example.demo.dto.pedido;

import com.example.demo.models.pedido.Pedido;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
public class PedidoDTO {

    private UUID id;
    private String De;
    private String Para;
    private String produto;
    private int quantidade;
    private String status;
    private String motivoCancelamento;
    private LocalDateTime dataPedido;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.De = pedido.getDe().getNome();
        this.Para = pedido.getPara().getNome();
        this.produto = pedido.getProduto();
        this.quantidade = pedido.getQuantidade();
        this.status = pedido.getStatus();
        this.motivoCancelamento = pedido.getMotivoCancelamento();
        this.dataPedido = pedido.getDataPedido();
    }
}
