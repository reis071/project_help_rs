package com.example.demo.models.cd;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Objects;

@Entity
@Getter@Setter
@NoArgsConstructor
public class Cd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    public Cd(String nome) {
        this.nome = nome;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cd cd = (Cd) o;
        return Objects.equals(id, cd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
