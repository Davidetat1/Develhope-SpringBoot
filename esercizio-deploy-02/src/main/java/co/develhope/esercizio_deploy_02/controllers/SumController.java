package co.develhope.esercizio_deploy_02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SumController {

    @GetMapping("/sum")
    public String getRandomSum() {
        Random random = new Random();
        int num1 = random.nextInt(100);  // per genersre un numero intero casuale tra 0 e 99
        int num2 = random.nextInt(100);
        int sum = num1 + num2;
        return "La somma di " + num1 + " e " + num2 + " è " + sum;
    }

}
