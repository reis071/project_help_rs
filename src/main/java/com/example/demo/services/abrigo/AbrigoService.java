package com.example.demo.services.abrigo;


import com.example.demo.controller.abrigo.AbrigoController;
import com.example.demo.daos.abrigo.AbrigoDAO;
import com.example.demo.daos.endereco.EnderecoDao;
import com.example.demo.daos.pedido.PedidoDAO;
import com.example.demo.dto.abrigo.AbrigoDTO;
import com.example.demo.dto.pedido.PedidoDTO;
import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.cd.Cd;
import com.example.demo.models.endereco.EnderecoAPI;
import com.example.demo.models.endereco.EnderecoModel;
import com.example.demo.models.pedido.Pedido;

import com.example.demo.repositories.cd.CdRp;
import com.example.demo.repositories.pedido.PedidoRP;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;

import org.springframework.stereotype.Service;


import static com.example.demo.config.hateoasLinks.AbrigoHateoas.linksHateoas;
import static com.example.demo.daos.endereco.EnderecoDao.buscarEndereco;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@AllArgsConstructor
@Service
public class AbrigoService {

        private final EnderecoDao enderecoDao;
        private final PedidoDAO pedidoDAO;
        private final CdRp cdRp;
        private final AbrigoDAO abrigoDAO;



    public AbrigoDTO registrarAbrigo(String nome, String cep ) {

        EnderecoAPI enderecoAPI = buscarEndereco(cep);

        EnderecoModel enderecoModel = new EnderecoModel(enderecoAPI);

        Abrigo abrigo = new Abrigo(nome);
        abrigo.setCep(enderecoModel);

        enderecoDao.cadastrarEndereco(enderecoModel);
        abrigoDAO.cadastrarAbrigo(abrigo);

        return  new AbrigoDTO(abrigo);
    }


    public PedidoDTO fazerPedido(Pedido pedido) {

        Cd cd = cdRp.findByNome(pedido.getPara().getNome());

        Abrigo abrigo = buscarAbrigoDetails(pedido.getDe().getNome());

        Hibernate.initialize(abrigo.getProdutos());

        Pedido pedidoNovo = new Pedido(pedido.getProduto(), pedido.getQuantidade(), abrigo,cd);

        pedidoDAO.cadastrarPedido(pedidoNovo);

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

}
