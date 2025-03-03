package com.example.demo.services.abrigo;

import com.example.demo.Exceptions.abrigo.AbrigoException;
import com.example.demo.Exceptions.endereco.EnderecoException;
import com.example.demo.dto.pedido.PedidoDTO;
import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.cd.Cd;
import com.example.demo.models.endereco.EnderecoAPI;
import com.example.demo.models.endereco.EnderecoModel;
import com.example.demo.models.pedido.Pedido;
import com.example.demo.repositories.abrigo.AbrigoRP;

import com.example.demo.repositories.endereco.EnderecoRepository;
import com.example.demo.repositories.pedido.PedidoRP;
import com.example.demo.services.cd.CdService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class AbrigoService {

    private final AbrigoRP abrigoRP;
    private final PedidoRP pedidoRP;
    private final EnderecoRepository enderecoRp;
    private final CdService cdService;


    @Transactional
    public Abrigo registrarAbrigo(String nome, String cep ) {
        EnderecoAPI enderecoAPI;

        enderecoAPI = buscarEndereco(cep);

        EnderecoModel enderecoModel = new EnderecoModel(enderecoAPI);

        Abrigo abrigo = new Abrigo(nome);

        enderecoRp.save(enderecoModel);

        abrigo.setCep(enderecoModel);
        return abrigoRP.save(abrigo);
    }

    @Transactional
    public PedidoDTO fazerPedido(Pedido pedido) {

        Cd cd = cdService.buscarCd(pedido.getPara().getNome());

        Abrigo abrigo = abrigoRP.findByNome(pedido.getDe().getNome());
        if (abrigo == null) {
            throw new AbrigoException("abrigo nao encontrado");
        }

        Hibernate.initialize(abrigo.getProdutos());

        Pedido pedidoNovo = new Pedido(pedido.getProduto(),pedido.getQuantidade(),
                abrigo,cd);

        pedidoRP.save(pedidoNovo);

        return new PedidoDTO(pedidoNovo);
    }

    public EnderecoAPI buscarEndereco(String cep) {
        RestTemplate consumidor = new RestTemplate();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
             return consumidor.getForObject(url, EnderecoAPI.class);
        }
        catch (Exception e) {
            throw new EnderecoException("Endereco nao encontrado");
        }
    }
}
