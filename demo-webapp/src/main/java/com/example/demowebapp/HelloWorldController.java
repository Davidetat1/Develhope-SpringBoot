package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping ("/v1")
public class HelloWorldController {
    @RequestMapping (method = GET, path = "/helloWorld")
    public String helloWorld(){
        return "Hello World! ";
    }
}
