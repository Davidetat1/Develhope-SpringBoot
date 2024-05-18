package co.develhope.esercizioOperazioni.Crud.repositories;

import co.develhope.esercizioOperazioni.Crud.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CarRepository extends JpaRepository<Car, Long> {

}
