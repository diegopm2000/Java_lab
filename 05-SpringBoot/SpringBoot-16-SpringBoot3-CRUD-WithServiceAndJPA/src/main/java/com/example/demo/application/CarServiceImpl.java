package com.example.demo.application;

import com.example.demo.api.CarInputForUpdateDTO;
import com.example.demo.api.CarNotFoundException;
import com.example.demo.domain.Car;
import com.example.demo.infrastructure.persistence.CarEntity;
import com.example.demo.infrastructure.persistence.CarMapper;
import com.example.demo.infrastructure.persistence.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper = CarMapper.INSTANCE;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll().stream()
                .map(carMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id)
                .map(carMapper::toDomain)
                .orElseThrow(() -> new CarNotFoundException(id));
    }
;
    @Override
    public Car create(Car car) {
        CarEntity carEntity = carMapper.toEntity(car);
        CarEntity savedEntity = carRepository.save(carEntity);
        return carMapper.toDomain(savedEntity);
    }

    @Override
    public Car update(Long id, CarInputForUpdateDTO updateInputData) {

        CarEntity carEntity = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        if (updateInputData.getModel() != null) {
            carEntity.setModel(updateInputData.getModel());
        }
        if (updateInputData.getBrand() != null) {
            carEntity.setBrand(updateInputData.getBrand());
        }
        if (updateInputData.getYear() != null) {
            carEntity.setYear(updateInputData.getYear());
        }

        CarEntity updatedEntity = carRepository.save(carEntity);
        return carMapper.toDomain(updatedEntity);
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
