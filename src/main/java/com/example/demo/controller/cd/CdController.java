package com.example.demo.controller.cd;

import com.example.demo.models.produtos.Roupa;
import com.example.demo.services.produtos.CdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cd")
public class CdController {

    private CdService cdService;

    public CdController(CdService cdService) {
        this.cdService = cdService;
    }



}
