package co.develhope.Esercizio_api_interceptor_middleware_01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/legacy")
public class LegacyController {

    @GetMapping
    public String getLegacyMessage(){
        return "this is just old code";
    }
}
