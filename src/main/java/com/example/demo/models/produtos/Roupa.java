package com.example.demo.models.produtos;

import com.example.demo.models.cd.Cd;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
public class Roupa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String tipo;

    private String tamanho;

    @ManyToOne
    @JoinColumn(name = "cd_id")
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
