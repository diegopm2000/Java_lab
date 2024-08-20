package com.example.demo.infrastructure.persistence;

import com.example.demo.domain.model.Car;
import com.example.demo.domain.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final CarJpaRepository carJpaRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarRepositoryImpl(CarJpaRepository carJpaRepository, CarMapper carMapper) {
        this.carJpaRepository = carJpaRepository;
        this.carMapper = carMapper;
    }

    @Override
    public List<Car> findAll() {
        return carJpaRepository.findAll().stream()
                .map(carMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carJpaRepository.findById(id)
                .map(carMapper::toDomain);
    }

    @Override
    public Car save(Car car) {
        CarEntity carEntity = carMapper.toEntity(car);
        CarEntity savedEntity = carJpaRepository.save(carEntity);
        return carMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        carJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return carJpaRepository.existsById(id);
    }
}
