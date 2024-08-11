package com.example.demo.application;

import com.example.demo.api.CarInputForUpdateDTO;
import com.example.demo.api.CarNotFoundException;
import com.example.demo.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> carList;
    private Long nextId;

    public CarServiceImpl() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1L, "Testarossa", "Ferrari", 1984));
        carList.add(new Car(2L, "911 Turbo", "Porsche", 1975));
        carList.add(new Car(3L, "Mustang", "Ford", 1965));
        nextId = 4L;
    }

    @Override
    public List<Car> getAll() {
        return this.carList;
    }

    @Override
    public Car getById(Long id) {
        return carList.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new CarNotFoundException(id));
    }

    @Override
    public Car create(Car car) {
        car.setId(nextId++);
        carList.add(car);
        return car;
    }

    @Override
    public Car update(Long id, CarInputForUpdateDTO updateInputData) {
        Car car = carList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException(id));

        if (updateInputData.getModel() != null && !updateInputData.getModel().trim().isEmpty()) {
            car.setModel(updateInputData.getModel().trim());
        }
        if (updateInputData.getBrand() != null && !updateInputData.getBrand().trim().isEmpty()) {
            car.setBrand(updateInputData.getBrand().trim());
        }
        if (updateInputData.getYear() != null && updateInputData.getYear() >= 1886) {
            car.setYear(updateInputData.getYear());
        }

        return car;
    }

    @Override
    public boolean delete(Long id) {
        return carList.removeIf(car -> car.getId().equals(id));
    }
}
