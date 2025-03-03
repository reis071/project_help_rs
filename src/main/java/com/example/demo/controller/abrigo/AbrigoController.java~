package com.example.demo.controller.abrigo;

import com.example.demo.dto.pedido.PedidoDTO;
import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.endereco.EnderecoAPI;
import com.example.demo.models.pedido.Pedido;
import com.example.demo.services.abrigo.AbrigoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/abrigo")
public class AbrigoController {

    private final AbrigoService abrigoService;

    @PostMapping("/registrarAbrigo")
    public Abrigo registrarAbrigo(@RequestBody Map<String, String> payload) {

        String cep = payload.get("cep");
        String nome = payload.get("nome");

        return abrigoService.registrarAbrigo(nome, cep);
    }

    @PostMapping("/fazerPedido")
    public PedidoDTO fazerPedido(@RequestBody Pedido pedido) {
        return abrigoService.fazerPedido(pedido);
    }
}
