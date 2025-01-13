package com.example.demo.models.cd;

import com.example.demo.models.produtos.Roupa;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Cd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "cd")
    private List<Roupa> roupas = new LinkedList<>();

}
