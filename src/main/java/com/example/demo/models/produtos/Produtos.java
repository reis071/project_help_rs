package com.example.demo.models.produtos;


import com.example.demo.models.cd.Cd;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;
    private int quantidadeDisponivel;

    @ManyToOne
    @JsonBackReference
    private Cd cd;

    public Produtos(String descricao, int quantidadeDisponivel, Cd cd) {
        this.descricao = descricao;

        this.quantidadeDisponivel = quantidadeDisponivel;
        this.cd = cd;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produtos produtos = (Produtos) o;
        return Objects.equals(id, produtos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
