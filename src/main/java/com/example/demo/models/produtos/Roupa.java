package com.example.demo.models.produtos;

import com.example.demo.models.cd.Cd;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter @Setter
public class Roupa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;

    private String tamanho;


    @ManyToOne
    @JoinColumn(name = "cd_id")
    @JsonBackReference
    private Cd cd;

    public Roupa() {}

    public Roupa(String tipo, String tamanho,Cd cd) {
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.cd = cd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roupa roupa = (Roupa) o;
        return Objects.equals(id, roupa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

