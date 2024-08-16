package com.example.demo.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Genera getters, setters, equals, hashCode, y toString automatically
@AllArgsConstructor
public class Car {
    Long id;

    @NotBlank(message = "Model must not be empty")
    String model;

    @NotBlank(message = "Brand must not be empty")
    String brand;

    @NotNull(message = "Year must not be null")
    @Min(value = 1886, message = "Year must be a positive number and cannot be less than 1886")
    Integer year;
}
