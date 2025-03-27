package com.example.demo.dto.cd;

import com.example.demo.models.cd.Cd;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter @Setter
public class CdDTO extends RepresentationModel<CdDTO> {

    private Long id;
    private String nome;

    public CdDTO(Cd cd) {
        this.id = cd.getId();
        this.nome = cd.getNome();
    }
}
