package com.example.demo.application;

import com.example.demo.api.CarInputForUpdateDTO;
import com.example.demo.api.CarNotFoundException;
import com.example.demo.domain.model.Car;
import com.example.demo.domain.repositories.CarRepository;
import com.example.demo.infrastructure.persistence.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    }
;
    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Long id, CarInputForUpdateDTO updateInputData) {

        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        if (updateInputData.getModel() != null) {
            car.setModel(updateInputData.getModel());
        }
        if (updateInputData.getBrand() != null) {
            car.setBrand(updateInputData.getBrand());
        }
        if (updateInputData.getYear() != null) {
            car.setYear(updateInputData.getYear());
        }

        return carRepository.save(car);
    }

    @Override
    public boolean delete(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        } else {
            throw new CarNotFoundException(id);
        }
    }
}
