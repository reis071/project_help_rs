package com.example.demo.models.pedido;

import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.cd.Cd;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String produto;

    private int quantidade;

    private String status;

    private String motivoCancelamento;
    private LocalDateTime dataPedido;

    @ManyToOne
    private Abrigo de;

    @ManyToOne
    private Cd para;

    public Pedido(String produto, int quantidade, Cd para, Abrigo de) {
        this.status = "Analise";
        this.motivoCancelamento = "";
        this.dataPedido = LocalDateTime.now();
        this.produto = produto;
        this.quantidade = quantidade;
        this.para = para;
        this.de = de;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
