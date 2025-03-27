package com.example.demo.repositories.endereco;

import com.example.demo.models.endereco.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRP extends JpaRepository<EnderecoModel, UUID> {
}
