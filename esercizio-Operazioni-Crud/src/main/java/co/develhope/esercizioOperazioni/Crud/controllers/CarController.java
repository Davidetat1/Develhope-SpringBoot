package co.develhope.esercizioOperazioni.Crud.controllers;

import co.develhope.esercizioOperazioni.Crud.entities.Car;
import co.develhope.esercizioOperazioni.Crud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    //CREATE (POST)
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        Car carSaved = carRepository.saveAndFlush(car);
        return carSaved;
    }

    //READ (GET)
    @GetMapping
    public List<Car> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

  //READ (GET)
  //metodo che restituisce una singola Car - se ID non è presente in db, restituisce Car vuota
    @GetMapping("/{id}")
    public ResponseEntity <Car> getCarById (@PathVariable long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get()); // 200 OK
        } else {
            return ResponseEntity.of(Optional.of(new Car())); // Return empty Car
        }
    }

    //UPDATE (PUT) aggiorna type della Car specifica, identificata da ID
    @PutMapping("/{id}/type")
    public ResponseEntity<Car> updateCarType(@PathVariable long id, @RequestParam String carType) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setCarType(carType);
            Car updatedCar = carRepository.saveAndFlush(car);
            return ResponseEntity.ok(updatedCar); // 200 OK
        } else {
            return ResponseEntity.of(Optional.of(new Car())); // Return empty Car if not found
        }
    }
    //DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 NO CONTENT
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 CONFLICT
        }
    }

    // DELETE all cars in db
    @DeleteMapping
    public void deleteCars(@RequestParam List<Long> ids) {
        carRepository.deleteAllById(ids);
    }
}
