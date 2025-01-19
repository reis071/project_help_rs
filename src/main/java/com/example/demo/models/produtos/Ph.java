package com.example.demo.models.produtos;

import com.example.demo.models.cd.Cd;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.Objects;


@Entity
public class Ph {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;

    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "cd_id", nullable = false)
    @JsonBackReference
    private Cd cd;

    public Ph() {}

    public Ph(String tipo, int quantidade, Cd cd) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.cd = cd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
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
