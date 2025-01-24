package com.example.demo.dto.cd;

import com.example.demo.models.cd.Cd;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CdDTO {

    private Long id;
    private String nome;

    public CdDTO(Cd cd) {
        this.id = cd.getId();
        this.nome = cd.getNome();
    }
}
