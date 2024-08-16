package com.example.demo.application;

import com.example.demo.api.CarInputForUpdateDTO;
import com.example.demo.domain.model.Car;

import java.util.List;

public interface CarService {
    public List<Car> getAll();
    public Car getById(Long id);
    public Car create(Car car);
    public Car update(Long id, CarInputForUpdateDTO updateInputData);
    public boolean delete(Long id);
}
