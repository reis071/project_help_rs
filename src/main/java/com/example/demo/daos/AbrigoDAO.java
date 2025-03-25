package com.example.demo.daos;

import com.example.demo.Exceptions.abrigo.AbrigoException;
import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.repositories.abrigo.AbrigoRP;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class AbrigoDAO {
    private final AbrigoRP abrigoRP;

    public Abrigo cadastrarAbrigo(Abrigo abrigo) {
        return abrigoRP.save(abrigo);
    }

    public Abrigo buscarAbrigo(String nome) {
        return abrigoRP.findByNome(nome).orElseThrow( () -> new AbrigoException("Abrigo nao encontrado"));
    }

    public Abrigo buscarAbrigoDetails(String nome) {
        return abrigoRP.findByNome(nome).orElseThrow( () -> new AbrigoException("Abrigo nao encontrado"));
    }

}
