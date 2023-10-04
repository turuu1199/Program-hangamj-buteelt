package com.sict.springbootmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/add-form")
	public String addForm() {
		return "add_form";
	}
}
