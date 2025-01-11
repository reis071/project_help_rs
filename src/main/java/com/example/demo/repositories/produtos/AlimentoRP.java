package com.example.demo.repositories.produtos;

import com.example.demo.models.produtos.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlimentoRP extends JpaRepository<Alimento, UUID> {
}
