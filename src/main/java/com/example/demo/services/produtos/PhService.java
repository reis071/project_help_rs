package com.example.demo.services.produtos;

import com.example.demo.models.produtos.Ph;
import com.example.demo.repositories.produtos.PhRP;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PhService {

    private final PhRP phRp;

    public void save(Ph ph) {
        phRp.save(ph);
    }

    public Optional<Ph> findById(UUID id) {
        return phRp.findById(id);
    }

    public void delete(UUID id) {
        phRp.deleteById(id);
    }
}
