package com.example.demo.repositories.pedido;

import com.example.demo.models.cd.Cd;
import com.example.demo.models.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRP extends JpaRepository<Pedido, UUID> {

    @Query("SELECT p FROM Pedido p WHERE p.status = 'Analise' AND p.para = :cd")
    List<Pedido> findStatus(@Param("cd") Cd cd);
}
