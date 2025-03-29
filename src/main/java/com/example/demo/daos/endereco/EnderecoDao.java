package com.example.demo.daos.endereco;

import com.example.demo.config.Exceptions.endereco.EnderecoException;
import com.example.demo.models.endereco.EnderecoAPI;
import com.example.demo.models.endereco.EnderecoModel;
import com.example.demo.repositories.endereco.EnderecoRP;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;



@AllArgsConstructor
@Repository
public class EnderecoDao {
    private final EnderecoRP enderecoRP;

    @Transactional
    public void cadastrarEndereco(EnderecoModel enderecoModel) {
        enderecoRP.save(enderecoModel);
    }

    public static EnderecoAPI buscarEndereco(String cep) {
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
