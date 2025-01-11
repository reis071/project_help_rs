package com.example.demo.models.produtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Ph {

    @Id
    private UUID id;

    private String tipo;

    private int quantidade;

}
