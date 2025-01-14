package com.example.demo.controller.cd;

import com.example.demo.models.cd.Cd;
import com.example.demo.models.produtos.Alimento;
import com.example.demo.models.produtos.Roupa;
import com.example.demo.services.produtos.CdService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cd")
@AllArgsConstructor
public class CdController {

    private final CdService cdService;

    @PostMapping("/registrarCd")
    public Cd registrarCd(@RequestBody Cd cd) {
        return cdService.registrarCd(cd.getNome());
    }

    @PostMapping("/registrarRoupa")
    public Roupa registrarRoupa(@RequestBody Roupa roupa) {
        return cdService.registrarRoupa(roupa.getTipo(),roupa.getTamanho(),roupa.getCd().getNome());
    }

    @PostMapping("/registrarAlimento")
    public Alimento registrarAlimento(@RequestBody Alimento alimento) {
        return cdService.registrarAlimento(alimento.getTipo(),alimento.getQuantidade(),alimento.getMedida(),alimento.getCd().getNome());
    }

}
