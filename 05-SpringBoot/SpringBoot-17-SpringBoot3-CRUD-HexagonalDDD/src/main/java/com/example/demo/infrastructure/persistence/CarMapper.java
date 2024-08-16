package com.example.demo.infrastructure.persistence;

import com.example.demo.domain.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarEntity toEntity(Car car);

    Car toDomain(CarEntity carEntity);
}
