package com.example.demo.services.produtos;

import com.example.demo.models.cd.Cd;
import com.example.demo.models.produtos.Alimento;
import com.example.demo.models.produtos.Roupa;
import com.example.demo.repositories.produtos.AlimentoRP;
import com.example.demo.repositories.produtos.RoupaRP;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.cd.CdRp;

import java.util.Optional;


@AllArgsConstructor
@Service
public class CdService {

    private final CdRp cdRP;
    private final RoupaRP roupaRP;
    private final AlimentoRP alimentoRP;


    public Cd registrarCd(String nome) {
        Cd cd = new Cd(nome);
        return cdRP.save(cd);
    }

    public  Roupa registrarRoupa(String tipo,String tamanho, String nomeCd) {

        Cd cd = cdRP.findByNome(nomeCd).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("CD com o nome fornecido não foi encontrado."));

        if (roupaRP.findByCd(cd).size() > 999){
            throw new RuntimeException("Limite de roupa atingido");
        }

        Roupa novaRoupa = new Roupa(tipo, tamanho, cd);

        roupaRP.save(novaRoupa);
        cd.getRoupas().add(novaRoupa);
        cdRP.save(cd);

        return novaRoupa;
    }

    public Alimento registrarAlimento(String tipo, int quantidade, String medida,String nomeCd) {

        Cd cd = cdRP.findByNome(nomeCd).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("CD com o nome fornecido não foi encontrado."));

             int quantidadeTotal = alimentoRP.findByCd(cd).stream().mapToInt(Alimento::getQuantidade).sum();

             if (quantidadeTotal + quantidade > 999) {
                 throw new RuntimeException("Limite de alimento atingido");
             }

             return alimentoRP.save(new Alimento(tipo, quantidade, medida, cd));

    }

}
