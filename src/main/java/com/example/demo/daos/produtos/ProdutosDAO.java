package com.example.demo.daos.produtos;

import com.example.demo.models.produtos.Produtos;
import com.example.demo.repositories.produtos.ProdutosRP;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class ProdutosDAO {

    private final ProdutosRP produtosRP;

    public Produtos cadastrarProduto(Produtos produtos) {
        return produtosRP.save(produtos);
    }


}
