package com.example.demo.repositories.abrigo;

import com.example.demo.models.abrigo.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbrigoRP extends JpaRepository<Abrigo, Long> {
    Abrigo findByNome(String nome);


}
