package com.example.demo.daos.abrigo;

import com.example.demo.Exceptions.abrigo.AbrigoException;
import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.repositories.abrigo.AbrigoRP;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class AbrigoDAO {
    private final AbrigoRP abrigoRP;

    @Transactional
    public Abrigo cadastrarAbrigo(Abrigo abrigo) {
        return abrigoRP.save(abrigo);
    }

    @Transactional
    public Abrigo buscarAbrigo(String nome) {
        return abrigoRP.findByNome(nome).orElseThrow( () -> new AbrigoException("Abrigo nao encontrado"));
    }

    @Transactional
    public Abrigo buscarAbrigoDetails(String nome) {
        return abrigoRP.findByNome(nome).orElseThrow( () -> new AbrigoException("Abrigo nao encontrado"));
    }



}
