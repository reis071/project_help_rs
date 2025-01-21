package com.example.demo.models.pedido;

import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.cd.Cd;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String status;
    private String motivoCancelamento;
    private LocalDateTime dataPedido;

    @ManyToOne
    private Abrigo de;

    @ManyToOne
    private Cd para;

    public Pedido(String status, String motivoCancelamento, LocalDateTime dataPedido) {
        this.status = status;
        this.motivoCancelamento = motivoCancelamento;
        this.dataPedido = dataPedido;
    }

}
