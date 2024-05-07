package com.example.demowebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class salutoController {
    @GetMapping(path = "v1/ciao")
    public String ciao(@RequestParam String nome, @RequestParam String regione){
        return "ciao " + nome + " com'è il tempo in " + regione + "?";
    }

}
