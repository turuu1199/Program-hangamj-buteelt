package com.sict.springbootmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/seeEmployees")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.getAllEmployees());
        return "employees";
    }
    @GetMapping("/addEmployee")
    public String addEmployee() {
    	return "addemployee";
    }
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestParam("id") int id,
    						  @RequestParam("fname") String fname,
    						  @RequestParam("lname") String lname,
    						  @RequestParam("email") String email) {
    	Employee newEmployee = new Employee(id, fname, lname,email);
    	employeeRepository.saveEmployee(newEmployee);
    	return "redirect:/seeEmployees";
    }
}