package com.example.demoweb.controller;

import com.example.demoweb.model.Person;
import com.example.demoweb.repo.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @Autowired
    private IPersonRepo repo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        // Normally, we will use a Service module to encapsulate this..but for simplicity we will use this approach
        Person p = new Person();
        p.setIdPerson(1);
        p.setName("Person Test");
        repo.save(p);

        model.addAttribute("name", name);
        return "greeting"; // NOTE: Go to greeting.html view
    }

    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("persons", repo.findAll());
        return "greeting"; // NOTE: Go to greeting.html view
    }
}
