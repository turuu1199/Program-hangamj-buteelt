package com.example.lab1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lab1Controller {

    @GetMapping("/")
    public String index() {
        return "HelloWorld!";
    }

}