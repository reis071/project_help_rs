package com.example.demo.models.cd;


import com.example.demo.models.produtos.Alimento;
import com.example.demo.models.produtos.Ph;
import com.example.demo.models.produtos.Roupa;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.*;

@Entity
@Getter@Setter
@NoArgsConstructor
public class Cd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "cd", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Roupa> roupas  = new HashSet<>();

    @OneToMany(mappedBy = "cd", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Alimento> alimentos = new HashSet<>();

    @OneToMany(mappedBy = "cd", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ph> produtosHigiene = new HashSet<>();

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
