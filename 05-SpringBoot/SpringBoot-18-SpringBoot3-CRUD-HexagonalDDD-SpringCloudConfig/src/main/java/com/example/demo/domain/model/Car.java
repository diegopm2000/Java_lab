package com.example.demo.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Car {
    Long id;

    @NotBlank(message = "Model must not be empty")
    String model;

    @NotBlank(message = "Brand must not be empty")
    String brand;

    @NotNull(message = "Year must not be null")
    @Min(value = 1886, message = "Year must be a positive number and cannot be less than 1886")
    Integer year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Model must not be empty") String getModel() {
        return model;
    }

    public void setModel(@NotBlank(message = "Model must not be empty") String model) {
        this.model = model;
    }

    public @NotBlank(message = "Brand must not be empty") String getBrand() {
        return brand;
    }

    public void setBrand(@NotBlank(message = "Brand must not be empty") String brand) {
        this.brand = brand;
    }

    public @NotNull(message = "Year must not be null") @Min(value = 1886, message = "Year must be a positive number and cannot be less than 1886") Integer getYear() {
        return year;
    }

    public void setYear(@NotNull(message = "Year must not be null") @Min(value = 1886, message = "Year must be a positive number and cannot be less than 1886") Integer year) {
        this.year = year;
    }

    public Car(Long id, String model, String brand, Integer year) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    public Car() {

    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                '}';
    }
}
