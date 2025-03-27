package com.example.demo.config.hateoasLinks.cd;


import com.example.demo.controller.cd.CdController;

import com.example.demo.dto.cd.CdDTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class CdHateoas {

    public static void cdHateoasLinks(CdDTO cdDTO) {
        cdDTO.add(linkTo(methodOn(CdController.class).registrarCd(null)).withRel("cadastrarCd").withType("POST"));
        cdDTO.add(linkTo(methodOn(CdController.class).listarCd(cdDTO.toString())).withRel("aceitarPedido").withType("POST"));


    }
}
