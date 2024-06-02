package com.example.esercizio_Spring.Boot_custom_queries1.repositories;

import com.example.esercizio_Spring.Boot_custom_queries1.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
}
