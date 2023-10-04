package com.example.lab1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lab1Controller {

    @GetMapping("/")
    public Map<String, Object> index() {
        int a = 10, b=5,c;
        c= a *b ;
        Map<String, Object> response = new HashMap<>();
        response.put("A",a);
        response.put("B",b);
        response.put("C",c);
        return response;
    }
}