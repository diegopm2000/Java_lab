package com.example.demo.api;

import com.example.demo.application.CarService;
import com.example.demo.domain.model.Car;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRestController {

    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {

        return this.carService.getAll();
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable Long id) {

        return this.carService.getById(id);
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car newCar) {
        Car carResult = this.carService.create(newCar);
        return new ResponseEntity<>(carResult, HttpStatus.CREATED);
    }

    @PatchMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody @Valid CarInputForUpdateDTO updateInputData) {
        Car carResult = this.carService.update(id, updateInputData);
        return new ResponseEntity<>(carResult, HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        boolean removed = this.carService.delete(id);

        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new CarNotFoundException(id);
        }
    }
}
