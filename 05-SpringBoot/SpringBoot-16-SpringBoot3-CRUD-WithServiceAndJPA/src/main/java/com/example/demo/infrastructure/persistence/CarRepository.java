package com.example.demo.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    // Custom queries could be added here if needed
}
