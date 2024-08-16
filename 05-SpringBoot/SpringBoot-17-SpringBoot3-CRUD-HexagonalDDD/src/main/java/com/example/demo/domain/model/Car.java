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

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    // Constructor

    public Car(Long id, String model, String brand, Integer year) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
    }
}
