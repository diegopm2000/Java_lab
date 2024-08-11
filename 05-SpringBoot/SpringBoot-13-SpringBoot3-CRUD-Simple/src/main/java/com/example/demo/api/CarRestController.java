package com.example.demo.api;

import com.example.demo.domain.Car;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarRestController {

    private List<Car> carList;
    private Long nextId;

    public CarRestController() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1L, "Testarossa", "Ferrari", 1984));
        carList.add(new Car(2L, "911 Turbo", "Porsche", 1975));
        carList.add(new Car(3L, "Mustang", "Ford", 1965));
        nextId = 4L;
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return this.carList;
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable Long id) {

        return carList.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new CarNotFoundException(id));
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car newCar) {
        newCar.setId(nextId++);
        carList.add(newCar);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PatchMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody @Valid CarInputForUpdateDTO updates) {
        Car car = carList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException(id));

        boolean updated = false;
        if (updates.getModel() != null && !updates.getModel().trim().isEmpty()) {
            car.setModel(updates.getModel().trim());
            updated = true;
        }
        if (updates.getBrand() != null && !updates.getBrand().trim().isEmpty()) {
            car.setBrand(updates.getBrand().trim());
            updated = true;
        }
        if (updates.getYear() != null && updates.getYear() >= 1886) {
            car.setYear(updates.getYear());
            updated = true;
        }

        if (!updated) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        boolean removed = carList.removeIf(car -> car.getId().equals(id));

        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new CarNotFoundException(id);
        }
    }
}
