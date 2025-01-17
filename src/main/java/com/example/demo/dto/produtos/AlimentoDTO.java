package com.example.demo.dto.produtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AlimentoDTO {
    private String tipo;
    private int quantidade;
    private String medida;

}
