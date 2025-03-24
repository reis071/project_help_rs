package com.example.demo.dto.abrigo;

import com.example.demo.models.abrigo.Abrigo;
import com.example.demo.models.endereco.EnderecoModel;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter @Setter
@JsonPropertyOrder({"id", "nome", "cep"}) // para mudar a ordem Serialization
public class AbrigoDTO extends RepresentationModel<AbrigoDTO> {

    private Long id;
    private String nome;
    private String cep;

    public AbrigoDTO(Abrigo abrigo) {
        this.id = abrigo.getId();
        this.nome = abrigo.getNome();
        this.cep = abrigo.getCep().getCep();
    }

}
