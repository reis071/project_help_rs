package com.example.demo.services.produtos;

import com.example.demo.models.produtos.Roupa;
import com.example.demo.repositories.produtos.RoupaRP;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoupaService {

    private final RoupaRP roupaRP;

    public void save(Roupa roupa) {
        roupaRP.save(roupa);
    }

    public Optional<Roupa> findById(UUID id) {
        return roupaRP.findById(id);
    }

    public void delete(UUID id) {
        roupaRP.deleteById(id);
    }
}
