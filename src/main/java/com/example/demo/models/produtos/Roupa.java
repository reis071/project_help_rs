package com.example.demo.models.produtos;

import com.example.demo.models.cd.Cd;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Roupa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;

    private String tamanho;

    @ManyToOne
    @JoinColumn(name = "cd_id", nullable = false)
    private Cd cd;

    public Roupa() {}

    public Roupa(String tipo, String tamanho) {
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Roupa roupa = (Roupa) o;
        return Objects.equals(id, roupa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

