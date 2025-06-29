package com.flps.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ninjas")
public class Controller {
    @GetMapping("/bem-vindo")
    public  String boaVindas(){
        return  "Seja bem-vindo";
    }
}
