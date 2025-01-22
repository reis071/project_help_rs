package com.example.demo.dto.abrigo;

import com.example.demo.models.abrigo.Abrigo;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AbrigoDTO {

    private Long id;
    private String nome;
    private String cep;
    private String email;

    public AbrigoDTO(Abrigo abrigo) {
        this.id = abrigo.getId();
        this.nome = abrigo.getNome();
        this.cep = abrigo.getCep();
        this.email = abrigo.getEmail();
    }
}
