package com.example.demo.controller;

import com.example.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @GetMapping("/show")
    public Mono<Person> show() {
        return Mono.just(new Person(1, "Person One"));
    }

    @GetMapping
    public Flux<Person> list() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Person One"));
        persons.add(new Person(1, "Person Two"));

        Flux<Person> personsFlux = Flux.fromIterable(persons);

        return personsFlux;
    }

    @GetMapping("/response")
    public Mono<ResponseEntity<Flux<Person>>> listEntity() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Person One"));
        persons.add(new Person(1, "Person Two"));

        Flux<Person> personsFlux = Flux.fromIterable(persons);

        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(personsFlux));
    }

    @DeleteMapping("/{mode}")
    public Mono<ResponseEntity<Void>> remove(@PathVariable("mode") Integer mode) {
        return searchPerson(mode)
                .flatMap(p -> {
                    return remove(p)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
                }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    public Mono<Void> remove(Person p) {
        log.info("Removing " + p.getIdPerson() + " - " + p.getName());
        return Mono.empty();
    }

    public Mono<Person> searchPerson(Integer mode) {
        if (mode == 1) {
            return Mono.just(new Person(1, "Person One"));
        } else {
            return Mono.empty();
        }
    }
}
