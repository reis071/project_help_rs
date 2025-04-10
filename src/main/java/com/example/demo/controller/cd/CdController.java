package com.example.demo.controller.cd;


import com.example.demo.dto.cd.CdDTO;
import com.example.demo.dto.pedido.PedidoDTO;
import com.example.demo.models.cd.Cd;
import com.example.demo.models.produtos.Produtos;
import com.example.demo.services.cd.CdService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.springframework.web.servlet.function.ServerResponse.status;

@AllArgsConstructor
@RestController
@RequestMapping("/cd")
public class CdController {


    private final CdService cdService;

    @PostMapping( name = "/registrarCd")
    public CdDTO registrarCd(@RequestBody Cd cd) {
        return cdService.registrarCd(cd);
    }

    @GetMapping("/buscarCd")
    public CdDTO listarCd(@RequestParam String cd) {
        return  cdService.buscarCd(cd);
    }

    @PostMapping("/registrarProduto")
    public ResponseEntity<Produtos> registrarProduto(@RequestBody Produtos produtos) {
        Produtos produto = cdService.cadastrarProdutosCd(produtos);
        return  ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    //Content Negotiation
    @GetMapping(value = "/visualizarPedido", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PedidoDTO>> visualizarPedido(@RequestParam String nomeCd) {
        return ResponseEntity.status(HttpStatus.OK).body(cdService.visualizarPedido(nomeCd));
    }

    @PostMapping("/aceitarPedido")
    public String aceitarPedido(@RequestBody Map<String, String> payload) {
        UUID id = UUID.fromString(payload.get("id"));
        return cdService.aceitarPedido(id);
    }


    @PatchMapping("/recusarPedido")
    public String recusarPedido(@RequestBody Map<String, String> payload) {
        UUID id = UUID.fromString(payload.get("id"));
        String motivoCancelamento = payload.get("motivoCancelamento");
        return cdService.negarPedido(id, motivoCancelamento);
    }

}
