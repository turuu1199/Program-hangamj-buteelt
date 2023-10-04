package com.example.lab3a;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping ("/hello")
	public String index() {
		return "U just pressed press here.";
	}
} 
