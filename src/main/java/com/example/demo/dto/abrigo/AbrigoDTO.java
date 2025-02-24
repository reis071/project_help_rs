package com.example.demo.dto.abrigo;

import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.endereco.EnderecoModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AbrigoDTO {

    private Long id;
    private String nome;
    private String email;
    private EnderecoModel cep;

    public AbrigoDTO(Abrigo abrigo) {
        this.id = abrigo.getId();
        this.nome = abrigo.getNome();
        this.cep = abrigo.getCep();
    }

}
