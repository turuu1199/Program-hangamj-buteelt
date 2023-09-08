package com.example.Ticketing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketingController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!123";
    }

}