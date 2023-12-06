package com.sictdb.lab6.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sictdb.lab6.model.User;
import com.sictdb.lab6.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public User createUser(User user) {
		return repository.save(user);
	}
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	public User getUserById(long id) {
		return repository.findById(id).orElse(null);
	}
	public void deleteUserById(long id) {
		repository.deleteById(id);
	}
	public User updateUser(User user) {
	     return repository.save(user);
	}
}