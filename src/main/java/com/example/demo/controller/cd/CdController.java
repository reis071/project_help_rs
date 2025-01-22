package com.example.demo.controller.cd;


import com.example.demo.dto.cd.CdDTO;
import com.example.demo.dto.pedido.PedidoDTO;
import com.example.demo.models.cd.Cd;
import com.example.demo.models.produtos.Produtos;
import com.example.demo.services.cd.CdService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/cd")
public class CdController {

    private final CdService cdService;

    @PostMapping("/registrarCd")
    public CdDTO registrarCd(@RequestBody Cd cd) {
        return cdService.registrarCd(cd);
    }

    @GetMapping("/buscarCd")
    public Cd listarCd(@RequestParam String cd) {
        return cdService.buscarCd(cd);
    }

    @PostMapping("/registrarProduto")
    public Produtos registrarProduto(@RequestBody Produtos produtos) {

        return cdService.cadastrarProdutosCd(produtos);
    }

    @GetMapping("/visualizarPedido")
    public List<PedidoDTO> visualizarPedido(@RequestParam String nomeCd) {
        return cdService.visualizarPedido(nomeCd);
    }

    @PostMapping("/aceitarPedido")
    public String aceitarPedido(@RequestBody Map<String, String> payload) {
        UUID id = UUID.fromString(payload.get("id"));
        return cdService.aceitarPedido(id);
    }
}
