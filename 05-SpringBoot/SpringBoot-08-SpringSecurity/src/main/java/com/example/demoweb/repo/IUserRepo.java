package com.example.demoweb.repo;

import com.example.demoweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {

    User findByName(String name);

}
