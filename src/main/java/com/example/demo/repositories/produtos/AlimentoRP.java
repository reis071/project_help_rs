package com.example.demo.repositories.produtos;

import com.example.demo.models.produtos.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlimentoRP extends JpaRepository<Alimento, UUID> {
}
