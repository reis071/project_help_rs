package com.example.demo.models.produtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Alimento {

    @Id
    private UUID id;

    private String tipo;

    private int quantidade;

    private String medida;
}
