package com.example.demo.models.abrigo;



import com.example.demo.models.endereco.EnderecoModel;
import com.example.demo.models.produtos.Produtos;

import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoModel cep;

    private int CapacidadeTotal = 1000;

    @OneToMany
    private Set<Produtos> produtos = new HashSet<>();



    public Abrigo(String nome) {
        this.nome = nome;
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
