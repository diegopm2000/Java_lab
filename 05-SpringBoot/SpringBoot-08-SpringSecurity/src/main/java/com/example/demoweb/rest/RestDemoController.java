package com.example.demoweb.rest;

import com.example.demoweb.model.Person;
import com.example.demoweb.repo.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class RestDemoController {

    @Autowired
    private IPersonRepo repo;

    @GetMapping
    public List<Person> list() {
        return repo.findAll();
    }

    @PostMapping
    public void insert(@RequestBody Person per) {
        repo.save(per);
    }

    @PutMapping
    public void update(@RequestBody Person per) {
        repo.save(per);
    }

    @DeleteMapping(value = "/{id}")
    public void insert(@PathVariable("id") Integer id) {
        repo.deleteById(id);
    }

}
