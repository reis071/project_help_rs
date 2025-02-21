package com.example.demo.controller.abrigo;

import com.example.demo.dto.pedido.PedidoDTO;
import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.endereco.Endereco;
import com.example.demo.models.pedido.Pedido;
import com.example.demo.services.abrigo.AbrigoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/abrigo")
public class AbrigoController {

    private final AbrigoService abrigoService;

    @PostMapping("/registrarAbrigo")
    public Abrigo registrarAbrigo(@RequestBody Abrigo abrigo) {
        return abrigoService.registrarAbrigo(abrigo);
    }

    @PostMapping("/fazerPedido")
    public PedidoDTO fazerPedido(@RequestBody Pedido pedido) {
        return abrigoService.fazerPedido(pedido);
    }
<<<<<<< HEAD

    @GetMapping("/buscarEndereco")
    public Endereco buscarEndereco(@RequestParam String cep) {
        return abrigoService.buscarEndereco(cep);
    }
=======
    
>>>>>>> cefe73e30eb079909c901f0a0251f80e84830bfd
}
