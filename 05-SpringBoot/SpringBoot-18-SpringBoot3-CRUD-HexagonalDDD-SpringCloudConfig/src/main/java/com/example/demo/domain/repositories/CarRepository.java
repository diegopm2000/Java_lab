package com.example.demo.domain.repositories;

import com.example.demo.api.CarInputForUpdateDTO;
import com.example.demo.domain.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    public List<Car> findAll();
    public Optional<Car> findById(Long id);
    public Car save(Car car);
    public void deleteById(Long id);
    public boolean existsById(Long id);
}
