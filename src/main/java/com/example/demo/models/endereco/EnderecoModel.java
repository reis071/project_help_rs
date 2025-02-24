package com.example.demo.models.endereco;

import com.example.demo.models.abrigo.Abrigo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@Entity
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ddd;

    @OneToOne(mappedBy = "cep")
    private Abrigo abrigo;

    public EnderecoModel(EnderecoAPI enderecoAPI) {
        this.cep = enderecoAPI.getCep();
        this.logradouro = enderecoAPI.getLogradouro();
        this.complemento = enderecoAPI.getComplemento();
        this.bairro = enderecoAPI.getBairro();
        this.localidade = enderecoAPI.getLocalidade();
        this.uf = enderecoAPI.getUf();
        this.estado = enderecoAPI.getEstado();
        this.regiao = enderecoAPI.getRegiao();
        this.ddd = enderecoAPI.getDdd();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoModel that = (EnderecoModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
