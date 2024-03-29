package com.boot.spring.restfulwebservices.controllers;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.boot.spring.restfulwebservices.beans.User;
import com.boot.spring.restfulwebservices.dao.UserDaoService;
import com.boot.spring.restfulwebservices.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UsersController {

	Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("v1/users")
	public ResponseEntity<List<User>> getAllUsers() {
		logger.info("An INFO Message");
		List<User> users = userDaoService.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(users, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("v1/users/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		logger.info("An INFO Message");
		User user = userDaoService.findById(id);
		if (user == null) {
			throw new UserNotFoundException("data not found for id = " + id);
		}
		return user;
	}

	@GetMapping("v2/users/{id}")
	public ResponseEntity<User> getUserV2(@PathVariable("id") Integer id) {
		logger.info("An INFO Message");
		User user = userDaoService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("hateoas/users/{id}")
	public EntityModel<User> getUserByHateoas(@PathVariable("id") Integer id) {
		logger.info("An INFO Message");
		User user = userDaoService.findById(id);
		if (user == null) {
			throw new UserNotFoundException("data not found for id = " + id);
		}
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(webMvcLinkBuilder.withRel("all-users"));
		return entityModel;
	}

	@PostMapping("v1/users")
	public ResponseEntity<User> createUserV1(@Valid @RequestBody User user) {
		logger.info("An INFO Message");
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PostMapping("v2/users")
	public ResponseEntity<User> createUserV2(@Valid @RequestBody User user) {
		logger.info("An INFO Message");
		User savedUser = userDaoService.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("v1/users/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		logger.info("An INFO Message");
		return userDaoService.deleteById(id);
	}
}