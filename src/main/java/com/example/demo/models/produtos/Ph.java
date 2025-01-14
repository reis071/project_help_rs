package com.example.demo.models.produtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
