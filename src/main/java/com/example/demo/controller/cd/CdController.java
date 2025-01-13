package com.example.demo.controller.cd;

import com.example.demo.models.cd.Cd;
import com.example.demo.models.produtos.Roupa;
import com.example.demo.services.produtos.CdService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cd")
public class CdController {

    private CdService cdService;

    public CdController(CdService cdService) {
        this.cdService = cdService;
    }

    @PostMapping("/registrarCd")
    public Cd registrarCd(@RequestBody Cd cd) {
        return cdService.registrarCd(cd.getNome());
    }

    @PostMapping("/registrarRoupa")
    public Roupa registrarRoupa(@RequestBody Roupa roupa) {
        return cdService.registrarRoupa(roupa.getTipo(),roupa.getTamanho(),roupa.getCd().getNome());
    }

}
