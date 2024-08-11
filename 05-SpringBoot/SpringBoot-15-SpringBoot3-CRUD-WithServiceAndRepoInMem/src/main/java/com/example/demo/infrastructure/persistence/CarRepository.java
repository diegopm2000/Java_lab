package com.example.demo.infrastructure.persistence;

import com.example.demo.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    public List<Car> findAll();
    public boolean existsById(Long id);
    public Optional<Car> findById(Long id);
    public Car save(Car car);
    public boolean deleteById(Long id);
}
