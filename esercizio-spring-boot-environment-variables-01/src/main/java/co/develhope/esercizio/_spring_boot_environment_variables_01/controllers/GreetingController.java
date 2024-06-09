package co.develhope.esercizio._spring_boot_environment_variables_01.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${devName}")
    private String devName;

    @Value("${authCode}")
    private String authCode;

    @GetMapping("/greet")
    public String greet() {
        return "Hello, " + devName + "! Your auth code is " + authCode;
    }
}
