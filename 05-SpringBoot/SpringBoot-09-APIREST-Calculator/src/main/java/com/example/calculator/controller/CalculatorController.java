package com.example.calculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private static final Logger log = LoggerFactory.getLogger(CalculatorController.class);

    @GetMapping("/add")
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        log.info("add --> (IN) --> parameters: a: "+ a+", b: " + b);

        Integer result = a + b;

        log.info("add --> (OUT) --> result: "+ result);
        return result;
    }

    @GetMapping("/minus")
    public Integer minus(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        log.info("minus --> (IN) --> parameters: a: "+ a+", b: " + b);

        Integer result = a - b;

        log.info("minus --> (OUT) --> result: "+ result);
        return result;
    }

    @GetMapping("/multiply")
    public Integer multiply(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        log.info("multiply --> (IN) --> parameters: a: "+ a+", b: " + b);

        Integer result = a * b;

        log.info("multiply --> (OUT) --> result: "+ result);
        return result;
    }

    @GetMapping("/divide")
    public Integer divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        log.info("divide --> (IN) --> parameters: a: "+ a+", b: " + b);

        Integer result = a / b;

        log.info("divide --> (OUT) --> result: "+ result);
        return result;
    }
}
