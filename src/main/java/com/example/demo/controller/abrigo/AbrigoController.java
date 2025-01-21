package com.example.demo.controller.abrigo;

import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.services.abrigo.AbrigoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/abrigo")
public class AbrigoController {

    private final AbrigoService abrigoService;

    @PostMapping("/registrarAbrigo")
    public Abrigo registrarAbrigo(@RequestBody Abrigo abrigo) {
        return abrigoService.registrarAbrigo(abrigo);
    }


}
