package com.example.demoweb.repo;

import com.example.demoweb.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepo extends JpaRepository<Person, Integer> {


}
