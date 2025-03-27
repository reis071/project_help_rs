package com.example.demo.config.hateoasLinks.abrigo;

import com.example.demo.controller.abrigo.AbrigoController;
import com.example.demo.dto.abrigo.AbrigoDTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class AbrigoHateoas {

    public static void linksHateoas(AbrigoDTO abrigoDTO) {
        abrigoDTO.add(linkTo(methodOn(AbrigoController.class).buscarAbrigo(abrigoDTO.getNome())).withSelfRel().withType("GET"));
        abrigoDTO.add(linkTo(methodOn(AbrigoController.class).registrarAbrigo( null)).withRel("registrarAbrigo").withType("POST"));
        abrigoDTO.add(linkTo(methodOn(AbrigoController.class).fazerPedido( null)).withRel("fazerPedido").withType("POST"));
    }
}
