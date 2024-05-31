package com.example.esercizio_api_interceptor_middleware_02.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping("/")
    public String helloMessage(){
        return "Welcome everyone";
    }
}
