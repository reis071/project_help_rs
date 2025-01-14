package com.example.demo.repositories.produtos;

import com.example.demo.models.cd.Cd;
import com.example.demo.models.produtos.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentoRP extends JpaRepository<Alimento, Long> {
    List<Alimento> findByCd(Cd cd);
}
