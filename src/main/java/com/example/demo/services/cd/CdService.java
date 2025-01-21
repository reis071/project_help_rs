package com.example.demo.services.cd;


import com.example.demo.models.cd.Cd;

import com.example.demo.models.produtos.Produtos;
import com.example.demo.repositories.produtos.ProdutosRP;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.cd.CdRp;


@AllArgsConstructor
@Service
public class CdService {

    private final CdRp cdRP;
    private final ProdutosRP produtosRP;

    public Cd registrarCd(String cd) {
        return cdRP.save(new Cd(cd));
    }

    @Transactional
    public Cd buscarCd(String nomeCd){

        Cd cd = cdRP.findByNome(nomeCd)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("CD não encontrado"));

        Hibernate.initialize(cd.getProdutos());

        return cd;

    }

    @Transactional
    public Produtos cadastrarProdutosCd(Produtos produtos) {
        Cd cd = cdRP.findByNome(produtos.getCd().getNome()).stream().findFirst().
                orElseThrow(() -> new RuntimeException("CD nao encontrado"));

        cd.getProdutos().add(produtos);
        produtos.setCd(cd);
        return produtosRP.save(produtos);
    }




}
