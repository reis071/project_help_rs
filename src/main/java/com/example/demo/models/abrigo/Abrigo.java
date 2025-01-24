package com.example.demo.models.abrigo;



import com.example.demo.models.produtos.Produtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@NoArgsConstructor
@Entity
@Getter @Setter
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cep;

    private String email;

    private int CapacidadeTotal = 1000;

    @OneToMany
    private Set<Produtos> produtos = new HashSet<>();


    public Abrigo(String nome, String cep, String email) {
        this.nome = nome;
        this.cep = cep;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abrigo abrigo = (Abrigo) o;
        return Objects.equals(id, abrigo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
