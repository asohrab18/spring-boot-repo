package com.boot.spring.restfulwebservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.spring.restfulwebservices.beans.User;
import com.boot.spring.restfulwebservices.dao.UserDaoService;
import com.boot.spring.restfulwebservices.exceptions.UserNotFoundException;

@RestController
public class UsersController {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("v1/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userDaoService.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(users, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("v1/users/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		User user = userDaoService.findById(id);
		if (user == null) {
			throw new UserNotFoundException("data not found for id = " + id);
		}
		return user;
	}

	@GetMapping("v2/users/{id}")
	public ResponseEntity<User> getUserByIdV2(@PathVariable("id") Integer id) {
		User user = userDaoService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("v1/users")
	public ResponseEntity<User> createUserV1(@RequestBody User user) {
		User savedUser = userDaoService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping("v2/users")
	public ResponseEntity<User> createUserV2(@RequestBody User user) {
		User savedUser = userDaoService.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
}