package com.example.demo.controller.produtos;

import com.example.demo.models.produtos.Ph;
import com.example.demo.services.produtos.PhService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("ph")
@RestController
public class PhController {

    private PhService phService;

    public PhController(PhService phService) {
        this.phService = phService;
    }

    @PostMapping("save")
    public Ph save(@RequestBody Ph ph) {
        return phService.save(ph);
    }
}
