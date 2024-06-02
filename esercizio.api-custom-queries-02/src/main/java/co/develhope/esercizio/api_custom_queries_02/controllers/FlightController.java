package co.develhope.esercizio.api_custom_queries_02.controllers;

import co.develhope.esercizio.api_custom_queries_02.entities.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import co.develhope.esercizio.api_custom_queries_02.entities.Status;
import co.develhope.esercizio.api_custom_queries_02.repositories.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepo flightRepo;

    private Random random = new Random();

    private String generateRandomString(int length) {
        return random.ints(length, 'A', 'Z' + 1).mapToObj(c -> "" + (char) c).collect(Collectors.joining());
    }

    private Status getRandomStatus() {
        Status[] statuses = Status.values();
        return statuses[random.nextInt(statuses.length)];
    }

    @PostMapping("/provision")
    public List<Flight> provisionFlights(@RequestParam(value = "n", defaultValue = "100") int n) {
        List<Flight> flights = IntStream.range(0, n).mapToObj(i -> {
            Flight flight = new Flight();
            flight.setDescription("Flight " + (i + 1));
            flight.setFromAirport("Airport " + generateRandomString(3));
            flight.setToAirport("Airport " + generateRandomString(3));
            flight.setStatus(getRandomStatus());
            return flight;
        }).collect(Collectors.toList());

        return flightRepo.saveAll(flights);
    }

    @GetMapping
    public Page<Flight> getAllFlights(Pageable pageable) {
        return flightRepo.findAllByOrderByFromAirportAsc(pageable);
    }

    @GetMapping("/ontime")
    public List<Flight> getOntimeFlights() {
        return flightRepo.findByStatus(Status.ONTIME);
    }

    @GetMapping("/bystatus")
    public List<Flight> getFlightsByStatus(@RequestParam("p1") Status p1, @RequestParam("p2") Status p2) {
        return flightRepo.findFlightsByStatuses(p1, p2);
    }
}
