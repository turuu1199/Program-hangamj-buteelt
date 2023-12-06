package com.sict.springbootmvc;

import java.util.Collection;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    
    public Collection<Employee> getEmployees() {
        return employeeRepository.getAllEmployees();
    }
}
