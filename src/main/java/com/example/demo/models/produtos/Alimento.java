package com.example.demo.models.produtos;

import com.example.demo.models.cd.Cd;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Objects;

@Entity
@Getter @Setter
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;

    private int quantidade;

    private String medida;

    @ManyToOne
    @JoinColumn(name = "cd_id", nullable = false)
    private Cd cd;

    public Alimento() {}

    public Alimento(String tipo, int quantidade, String medida, Cd cd) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.medida = medida;
        this.cd = cd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alimento alimento = (Alimento) o;
        return Objects.equals(id, alimento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
