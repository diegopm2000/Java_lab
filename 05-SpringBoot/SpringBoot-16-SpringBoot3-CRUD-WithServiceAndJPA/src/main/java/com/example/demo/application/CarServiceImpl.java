package com.example.demo.application;

import com.example.demo.api.CarInputForUpdateDTO;
import com.example.demo.api.CarNotFoundException;
import com.example.demo.domain.Car;
import com.example.demo.infrastructure.persistence.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Car getById(Long id) {
        Optional<Car> innerCar = this.carRepository.findById(id);

        if (innerCar.isEmpty()) {
            throw new CarNotFoundException(id);
        }

        return innerCar.get();
    }
;
    @Override
    public Car create(Car car) {
        return this.carRepository.save(car);
    }

    @Override
    public Car update(Long id, CarInputForUpdateDTO updateInputData) {

        Optional<Car> innerCar = this.carRepository.findById(id);

        if (innerCar.isEmpty()) {
            throw new CarNotFoundException(id);
        }

        Car car = innerCar.get();

        if (updateInputData.getModel() != null && !updateInputData.getModel().trim().isEmpty()) {
            car.setModel(updateInputData.getModel().trim());
        }
        if (updateInputData.getBrand() != null && !updateInputData.getBrand().trim().isEmpty()) {
            car.setBrand(updateInputData.getBrand().trim());
        }
        if (updateInputData.getYear() != null && updateInputData.getYear() >= 1886) {
            car.setYear(updateInputData.getYear());
        }

        return this.carRepository.save(car);
    }

    @Override
    public boolean delete(Long id) {
        return this.carRepository.deleteById(id);
    }
}
