package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.demo.domain.model.Car;
import com.example.demo.infrastructure.persistence.CarEntity;
import com.example.demo.infrastructure.persistence.CarMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarMapperTest {

    @Autowired
    private CarMapper carMapper;

    @Test
    void testCarMapper() {
        Car car = new Car(1L, "Model X", "Brand Y", 2023);
        CarEntity carEntity = carMapper.toEntity(car);
        System.out.println("CarEntity"+ carEntity.toString());

        assertNotNull(carEntity);
        assertEquals(car.getId(), carEntity.getId());
        assertEquals(car.getModel(), carEntity.getModel());
        assertEquals(car.getBrand(), carEntity.getBrand());
        assertEquals(car.getYear(), carEntity.getYear());

        Car mappedCar = carMapper.toDomain(carEntity);
        System.out.println("mappedCar"+ mappedCar.toString());

        assertNotNull(mappedCar);
        assertEquals(carEntity.getId(), mappedCar.getId());
        assertEquals(carEntity.getModel(), mappedCar.getModel());
        assertEquals(carEntity.getBrand(), mappedCar.getBrand());
        assertEquals(carEntity.getYear(), mappedCar.getYear());
    }
}
