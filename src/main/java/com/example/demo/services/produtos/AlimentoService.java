package com.example.demo.services.produtos;

import com.example.demo.models.produtos.Alimento;
import com.example.demo.models.produtos.Ph;
import com.example.demo.repositories.produtos.AlimentoRP;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AlimentoService {

    private final AlimentoRP alimentoRP;

    public void save(Alimento ph) {
        alimentoRP.save(ph);
    }

    public Optional<Alimento> findById(UUID id) {
        return alimentoRP.findById(id);
    }

    public void delete(UUID id) {
        alimentoRP.deleteById(id);
    }
}
