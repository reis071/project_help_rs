package com.example.demo.controller.cd;


import com.example.demo.models.cd.Cd;
import com.example.demo.models.produtos.Produtos;
import com.example.demo.services.cd.CdService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/cd")
public class CdController {

    private final CdService cdService;

    @PostMapping("/registrarCd")
    public Cd registrarCd(@RequestBody Map<String, String> payload) {
        String nome = payload.get("nome");
        return cdService.registrarCd(nome);
    }

    @GetMapping("/buscarCd")
    public Cd listarCd(@RequestParam String nome) {
        return cdService.buscarCd(nome);
    }

    @PostMapping("/registrarProduto")
    public Produtos registrarProduto(@RequestBody Produtos produtos) {

        return cdService.cadastrarProdutosCd(produtos);

    }

}
