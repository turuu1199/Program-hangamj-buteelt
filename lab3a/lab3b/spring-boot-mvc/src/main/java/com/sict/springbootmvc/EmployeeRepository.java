package com.sict.springbootmvc;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
	HashMap<Integer, Employee> db = new HashMap<Integer, Employee>();
	Employee emp1 = new Employee(1,"Baldan","Dorj","Baldan@gmail.com");
	Employee emp2 = new Employee(2,"Batuul","Enkhbyar","Batuul@gmail.com");
	Employee emp3 = new Employee(3,"Battulga","Khurelsukh","Batlaga@gmail.com");
	public EmployeeRepository() {
		 db.put(emp1.getId(), emp1);
		 db.put(emp2.getId(), emp2);
		 db.put(emp3.getId(), emp3);
	}
	public Collection<Employee> getAllEmployees() {
		return db.values();
	}
	public void saveEmployee(Employee employee) {
		db.put(employee.getId(),employee);
	}
}
