package com.example.demo.controller.produtos;

import com.example.demo.models.produtos.Alimento;
import com.example.demo.services.produtos.AlimentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/alimento")
@RestController
public class AlimentoController {
    private AlimentoService alimentoService;

    public AlimentoController(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }

    @PostMapping("/save")
    public Alimento save(@RequestBody Alimento alimento) {
        return alimentoService.save(alimento);
    }
}
