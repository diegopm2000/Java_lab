package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/")
    public String greeting() {
        return "index"; // With @RestController, the result will be the text, not the index html page
    }

    @GetMapping("/info")
    public String info() {
        return "This the info...lorem ipsum";
    }
}
