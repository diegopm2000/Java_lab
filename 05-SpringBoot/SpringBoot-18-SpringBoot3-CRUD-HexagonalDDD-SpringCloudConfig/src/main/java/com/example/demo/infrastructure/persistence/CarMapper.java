package com.example.demo.infrastructure.persistence;

import com.example.demo.domain.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarEntity toEntity(Car car);

    Car toDomain(CarEntity carEntity);
}
