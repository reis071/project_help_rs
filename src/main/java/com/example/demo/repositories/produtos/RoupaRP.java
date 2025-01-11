package com.example.demo.repositories.produtos;

import com.example.demo.models.produtos.Roupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoupaRP extends JpaRepository<Roupa, UUID> {
}
