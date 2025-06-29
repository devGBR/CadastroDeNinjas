package com.flps.CadastroDeNinjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ninjas")
public class NinjaController {
    @GetMapping("/bem-vindo")
    public  String boaVindas(){
        return  "Seja bem-vindo";
    }
}
