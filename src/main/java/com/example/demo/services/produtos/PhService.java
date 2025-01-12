package com.example.demo.services.produtos;

import com.example.demo.models.produtos.Ph;
import com.example.demo.repositories.produtos.PhRP;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PhService {

    private PhRP phRp;

    public PhService(PhRP phRp) {
        this.phRp = phRp;
    }

    public Ph save(Ph ph) {
       return phRp.save(ph);
    }

    public Optional<Ph> findById(Long id) {
        return phRp.findById(id);
    }

    public void delete(Long id) {
        phRp.deleteById(id);
    }
}