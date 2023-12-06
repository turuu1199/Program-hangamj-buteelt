package com.sictdb.lab6.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sictdb.lab6.model.User;
import com.sictdb.lab6.services.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService service;
	/*
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return service.createUser(user);
	} */
	
	@GetMapping("/user/{id}")
	public String findUserById(Model model,@PathVariable long id) {
		User user = service.getUserById(id);
	    model.addAttribute("users", user);
		return "user";
	}
	@GetMapping("/update/{id}")
	public String updateUserById(@PathVariable long id, Model model) {
	    User user = service.getUserById(id);
	    model.addAttribute("user", user);
	    return "edit-user";
	}
	@PostMapping("/update/{id}")
	public String updateUserById(@RequestParam("id") long id,
								 @RequestParam("fname") String fname,
								 @RequestParam("lname") String lname,
								 @RequestParam("email") String email) {
		User updateUser = new User(id,fname,lname,email);
		service.updateUser(updateUser); 
		return "redirect:/all-users";
	}
	@PostMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		service.deleteUserById(id);
		return "redirect:/all-users";
	}
	@GetMapping("/add-User")
	public String createUser() {
		return "add-users";
	}
	@GetMapping("/all-users")
	public String listUsers(Model model) {
	    List<User> users = service.getAllUsers();
	    model.addAttribute("users", users);
	    return "all-users"; 
	}
	@PostMapping("/add-user")
	public String createUser(@RequestParam("fname") String fname,
							 @RequestParam("lname") String lname,
							 @RequestParam("email") String email) {
	User newUser = new User(fname,lname,email);
	service.createUser(newUser);
	return "redirect:/all-users";
	}
	@GetMapping("/")
	public String home() {
		return "home";
	}
}