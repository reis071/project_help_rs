package com.example.demo.repositories.produtos;

import com.example.demo.models.produtos.Roupa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoupaRP extends JpaRepository<Roupa, UUID> {
}
