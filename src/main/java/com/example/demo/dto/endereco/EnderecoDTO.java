package com.example.demo.dto.endereco;

import com.example.demo.models.endereco.EnderecoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class EnderecoDTO {

    private String cep;
    private String regiao;
    private String estado;

    public EnderecoDTO(EnderecoModel enderecoModel) {
        this.cep = enderecoModel.getCep();
        this.regiao = enderecoModel.getRegiao();
        this.estado = enderecoModel.getEstado();
    }







}
