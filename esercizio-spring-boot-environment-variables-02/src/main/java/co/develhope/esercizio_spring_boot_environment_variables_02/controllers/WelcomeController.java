package co.develhope.esercizio_spring_boot_environment_variables_02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WelcomeController {
    @Autowired
    private Environment environment;

    @GetMapping
    public String welcome() {
        String welcome = environment.getProperty("welcomeMsg");
        return welcome;
    }
}
