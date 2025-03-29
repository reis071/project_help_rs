package com.example.demo.daos.cd;

import com.example.demo.config.Exceptions.cd.CdException;
import com.example.demo.dto.cd.CdDTO;
import com.example.demo.models.cd.Cd;
import com.example.demo.repositories.cd.CdRp;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class CdDAO {
    private final CdRp cdRp;

    @Transactional
    public CdDTO registrarCd(Cd cd) {
        cdRp.save(cd);

        return new CdDTO(cd);
    }


    @Transactional
    public Cd buscarCd(String nomeCd) {

        Cd cd = cdRp.findByNome(nomeCd);

        if( cd == null){
            throw new CdException("Centro de  Distribuição nao encontrado");
        }

        Hibernate.initialize(cd.getProdutos());

        return cd;

    }

}
