package com.example.demo.repositories.produtos;

import com.example.demo.models.produtos.Ph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhRP extends JpaRepository<Ph, Long> {

}
