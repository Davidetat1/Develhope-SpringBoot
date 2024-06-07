package com.example.esercizio_deploy_01.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Value("${devName}")
    private String devName;

    @GetMapping("/devName")
    public String getDevName() {
        return devName;
    }
}
