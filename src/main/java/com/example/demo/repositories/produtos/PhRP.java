package com.example.demo.repositories.produtos;

import com.example.demo.models.produtos.Ph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhRP extends JpaRepository<Ph, UUID> {
}
