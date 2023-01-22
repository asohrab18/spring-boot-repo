package com.boot.spring.restfulwebservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.restfulwebservices.beans.User;
import com.boot.spring.restfulwebservices.dao.UserDaoService;

@RestController
public class UsersController {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userDaoService.findAll();
		if(users.isEmpty()) {
			return new ResponseEntity<List<User>>(users, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		User user = userDaoService.findById(id);
		if(user == null) {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userDaoService.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
}