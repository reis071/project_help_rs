package com.example.demo.services.abrigo;

import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.repositories.abrigo.AbrigoRP;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AbrigoService {

    private final AbrigoRP abrigoRP;

    @Transactional
    public Abrigo registrarAbrigo(Abrigo abrigo) {
        return abrigoRP.save(new Abrigo(abrigo.getNome(),abrigo.getCep(),abrigo.getEmail()));
    }
}
