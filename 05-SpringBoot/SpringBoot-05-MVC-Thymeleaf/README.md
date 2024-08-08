# Spring Boot MVC + Thymeleaft

Example of Spring Boot with MVC and Thymeleaf

We have created a project using spring initializer adding the modules:

- web
- thymeleaft

## 1. The Controller

```java
package com.example.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting"; // NOTE: Go to greeting.html view
    }
}
```

## 2. The thymeleaf template

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text="'Hello, ' + ${name} + '!'" />
</body>
</html>
```

## 3. Test the application

```shell
curl -X GET http://localhost:8080/greeting?name=Diego
```

