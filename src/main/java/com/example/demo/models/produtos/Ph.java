package com.example.demo.models.produtos;

import com.example.demo.models.cd.Cd;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;


@Entity
@Data
public class Ph {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;

    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "cd_id", nullable = false)
    private Cd cd;

    public Ph() {}

    public Ph(String tipo, int quantidade) {
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ph ph = (Ph) o;
        return Objects.equals(id, ph.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
