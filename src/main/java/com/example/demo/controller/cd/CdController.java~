package com.example.demo.controller.cd;

import com.example.demo.dto.produtos.RoupaDTO;
import com.example.demo.models.cd.Cd;
import com.example.demo.models.produtos.Alimento;
import com.example.demo.models.produtos.Roupa;
import com.example.demo.services.produtos.CdService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController

@RequestMapping("/cd")
public class CdController {

    private  CdService cdService;

    public CdController(CdService cdService) {
        this.cdService = cdService;
    }

    @PostMapping("/registrarCd")
    public Cd registrarCd(@RequestBody Map<String, String> payload) {
        String nome = payload.get("nome");
        return cdService.registrarCd(nome);
    }

    @PostMapping(value="/registrarRoupa",consumes = {"application/json", "application/json;charset=UTF-8"})
    public RoupaDTO registrarRoupa(@RequestBody Roupa roupa) {
        return cdService.registrarRoupa(roupa.getTipo(),roupa.getTamanho(),roupa.getCd().getNome());
    }

    @PostMapping("/registrarAlimento")
    public Alimento registrarAlimento(@RequestBody Alimento alimento) {
        return cdService.registrarAlimento(alimento.getTipo(),alimento.getQuantidade(),alimento.getMedida(),alimento.getCd().getNome());
    }

}
