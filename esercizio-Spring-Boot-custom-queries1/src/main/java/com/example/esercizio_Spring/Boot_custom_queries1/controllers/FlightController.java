package com.example.esercizio_Spring.Boot_custom_queries1.controllers;

import com.example.esercizio_Spring.Boot_custom_queries1.entities.Flight;
import com.example.esercizio_Spring.Boot_custom_queries1.entities.Status;
import com.example.esercizio_Spring.Boot_custom_queries1.repositories.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepo flightRepo;

    @PostMapping("/provision")
    public List<Flight> provisionFlights() {
        Random random = new Random();

        List<Flight> flights = IntStream.range(0, 50).mapToObj(i -> {
            Flight flight = new Flight();
            flight.setDescription("Flight " + (i + 1));
            flight.setFromAirport(generateRandomString(random, 3));
            flight.setToAirport(generateRandomString(random, 3));
            flight.setStatus(Status.ONTIME);
            return flight;
        }).collect(Collectors.toList());

        return flightRepo.saveAll(flights);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    private String generateRandomString(Random random, int length) {
        return random.ints('A', 'Z' + 1)
                .limit(length)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }
}
