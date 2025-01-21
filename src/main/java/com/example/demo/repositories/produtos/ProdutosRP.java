package com.example.demo.repositories.produtos;

import com.example.demo.models.produtos.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRP extends JpaRepository<Produtos, Long> {

}
