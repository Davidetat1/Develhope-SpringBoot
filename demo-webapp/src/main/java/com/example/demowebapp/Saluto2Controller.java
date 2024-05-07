package com.example.demowebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saluto2Controller {
    @GetMapping(path = "/v2/ciao/{regione}")
    public User ciao(@RequestParam String nome, @PathVariable String regione){
        String saluto = "ciao " + nome + " com'è il tempo in " + regione + "?";
        return new User(nome,regione,saluto);
    }
}
