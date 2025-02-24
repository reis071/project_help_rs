package com.example.demo.models.endereco;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnderecoAPI {

    private Long id;
    private String cep;            // Código Postal
    private String logradouro;     // Rua
    private String complemento;    // Complemento
    private String unidade;        // Unidade (se aplicável)
    private String bairro;         // Bairro
    private String localidade;     // Cidade
    private String uf;             // Unidade Federativa (Estado)
    private String estado;         // Estado completo
    private String regiao;         // Região (Nordeste, por exemplo)
    private String ibge;           // Código IBGE
    private String gia;            // Código GIA (se aplicável)
    private String ddd;            // Código DDD
    private String siafi;          // Código SIAFI


}
