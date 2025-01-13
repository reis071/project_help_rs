package com.example.demo.services.produtos;

import com.example.demo.models.cd.Cd;
import com.example.demo.models.produtos.Roupa;
import com.example.demo.repositories.produtos.RoupaRP;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.cd.CdRp;

import java.util.List;

@Service
public class CdService {

    private CdRp cdRP;
    private RoupaRP roupaRP;

    public CdService(CdRp cdRP, RoupaRP roupaRP) {
        this.cdRP = cdRP;
        this.roupaRP = roupaRP;
    }

    public Roupa registrarRoupa(String tipo,String tamanho, String nomeCd) {
        Cd cd = cdRP.findByNome(nomeCd).get(0);
        Roupa roupa = new Roupa();

        roupa.setTamanho(tamanho);
        roupa.setTipo(tipo);
        roupa.setCd(cd);

        return  roupaRP.save(roupa);
    }


}
