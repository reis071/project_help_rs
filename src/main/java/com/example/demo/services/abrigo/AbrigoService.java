package com.example.demo.services.abrigo;

import com.example.demo.Exceptions.abrigo.AbrigoException;
import com.example.demo.Exceptions.endereco.EnderecoException;
import com.example.demo.controller.abrigo.AbrigoController;
import com.example.demo.daos.AbrigoDAO;
import com.example.demo.dto.abrigo.AbrigoDTO;
import com.example.demo.dto.pedido.PedidoDTO;
import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.cd.Cd;
import com.example.demo.models.endereco.EnderecoAPI;
import com.example.demo.models.endereco.EnderecoModel;
import com.example.demo.models.pedido.Pedido;

import com.example.demo.repositories.cd.CdRp;
import com.example.demo.repositories.endereco.EnderecoRepository;
import com.example.demo.repositories.pedido.PedidoRP;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@AllArgsConstructor
@Service
public class AbrigoService {


        private final PedidoRP pedidoRP;
        private final EnderecoRepository enderecoRp;
        private final CdRp cdRp;
        private final AbrigoDAO abrigoDAO;


    @Transactional
    public AbrigoDTO registrarAbrigo(String nome, String cep ) {
        EnderecoAPI enderecoAPI;

        enderecoAPI = buscarEndereco(cep);

        EnderecoModel enderecoModel = new EnderecoModel(enderecoAPI);

        Abrigo abrigo = new Abrigo(nome);


        abrigo.setCep(enderecoModel);
        enderecoRp.save(enderecoModel);
        abrigoDAO.cadastrarAbrigo(abrigo);

        return  new AbrigoDTO(abrigo);
    }

    @Transactional
    public PedidoDTO fazerPedido(Pedido pedido) {

        Cd cd = cdRp.findByNome(pedido.getPara().getNome());


        Abrigo abrigo = buscarAbrigoDetails(pedido.getDe().getNome());

        Hibernate.initialize(abrigo.getProdutos());

        Pedido pedidoNovo = new Pedido(pedido.getProduto(),pedido.getQuantidade(),
                abrigo,cd);

        pedidoRP.save(pedidoNovo);

        return new PedidoDTO(pedidoNovo);
    }

    public AbrigoDTO buscarAbrigo(String nomeAbrigo) {

        Abrigo abrigo = abrigoDAO.buscarAbrigo(nomeAbrigo);

        AbrigoDTO abrigoDTO = new AbrigoDTO(abrigo);

        linksHateoas(abrigoDTO);
        return abrigoDTO;
    }

    public Abrigo buscarAbrigoDetails(String nomeAbrigo) {
        return abrigoDAO.buscarAbrigoDetails(nomeAbrigo);
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

    private static void linksHateoas(AbrigoDTO abrigoDTO) {
        abrigoDTO.add(linkTo(methodOn(AbrigoController.class).buscarAbrigo(abrigoDTO.getNome())).withSelfRel().withType("GET"));
        abrigoDTO.add(linkTo(methodOn(AbrigoController.class).registrarAbrigo( null)).withRel("registrarAbrigo").withType("POST"));
        abrigoDTO.add(linkTo(methodOn(AbrigoController.class).fazerPedido( null)).withRel("fazerPedido").withType("POST"));
    }
}
