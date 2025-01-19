package com.example.demo.repositories.produtos;

import com.example.demo.models.cd.Cd;
import com.example.demo.models.produtos.Ph;
import com.example.demo.models.produtos.Roupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhRP extends JpaRepository<Ph, Long> {
    List<Ph> findByCd(Cd cd);
}
