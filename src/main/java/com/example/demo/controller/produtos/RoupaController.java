package com.example.demo.controller.produtos;

import com.example.demo.models.produtos.Roupa;
import com.example.demo.services.produtos.RoupaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/roupa")
@RestController
public class RoupaController {

    private RoupaService roupaService;

    public  RoupaController(RoupaService roupaService) {
        this.roupaService = roupaService;
    }

    @PostMapping("/save")
    public Roupa save(@RequestBody Roupa roupa) {
        return roupaService.save(roupa);
    }

}
