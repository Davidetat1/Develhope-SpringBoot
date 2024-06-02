package co.develhope.esercizio.api_custom_queries_02.repositories;

import co.develhope.esercizio.api_custom_queries_02.entities.Flight;
import co.develhope.esercizio.api_custom_queries_02.entities.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepo extends JpaRepository<Flight, Long> {
    Page<Flight> findAllByOrderByFromAirportAsc(Pageable pageable);

    List<Flight> findByStatus(Status status);

    @Query("SELECT f FROM Flight f WHERE f.status = :p1 OR f.status = :p2")
    List<Flight> findFlightsByStatuses(@Param("p1") Status p1, @Param("p2") Status p2);
}
