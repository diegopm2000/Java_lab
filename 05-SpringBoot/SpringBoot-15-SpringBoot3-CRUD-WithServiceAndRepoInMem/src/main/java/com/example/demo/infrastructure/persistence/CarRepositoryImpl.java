package com.example.demo.infrastructure.persistence;

import com.example.demo.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarRepositoryImpl implements CarRepository {
    private final Map<Long, Car> carStore = new HashMap<>();
    private long idCounter = 1L;

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(carStore.values());
    }

    @Override
    public boolean existsById(Long id) {
        return carStore.containsKey(id);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.ofNullable(carStore.get(id));
    }

    @Override
    public Car save(Car car) {
        if (car.getId() == null) {
            car.setId(idCounter++);
        }
        carStore.put(car.getId(), car);
        return car;
    }

    @Override
    public boolean deleteById(Long id) {
        return carStore.remove(id) != null;
    }
}
