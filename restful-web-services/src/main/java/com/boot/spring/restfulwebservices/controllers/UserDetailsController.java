package com.boot.spring.restfulwebservices.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.spring.restfulwebservices.beans.Designation;
import com.boot.spring.restfulwebservices.beans.UserDetails;
import com.boot.spring.restfulwebservices.dao.DesignationRepository;
import com.boot.spring.restfulwebservices.dao.UserDetailsRepository;
import com.boot.spring.restfulwebservices.exceptions.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserDetailsController {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private DesignationRepository designationRepository;
	
	public UserDetailsController(UserDetailsRepository userDetailsRepository,DesignationRepository designationRepository) {
		this.userDetailsRepository=userDetailsRepository;
		this.designationRepository=designationRepository;
	}
	
	@GetMapping("jpa/v1/users-details")
	public ResponseEntity<List<UserDetails>> getAllUserDetails() {
		List<UserDetails> userDetailsList = userDetailsRepository.findAll();
		if (userDetailsList.isEmpty()) {
			return new ResponseEntity<List<UserDetails>>(userDetailsList, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UserDetails>>(userDetailsList, HttpStatus.OK);
	}

	@GetMapping("jpa/v1/users-details/{id}")
	public UserDetails getUserDetails(@PathVariable("id") Integer id) {
		Optional<UserDetails> userDetailsOpt = userDetailsRepository.findById(id);
		if (!userDetailsOpt.isPresent() || userDetailsOpt.isEmpty()) {
			throw new UserNotFoundException("data not found for id = " + id);
		}
		return userDetailsOpt.get();
	}

	@GetMapping("jpa/v2/users-details/{id}")
	public ResponseEntity<UserDetails> getUserDetailsV2(@PathVariable("id") Integer id) {
		Optional<UserDetails> userDetailsOpt = userDetailsRepository.findById(id);
		if (!userDetailsOpt.isPresent() || userDetailsOpt.isEmpty()) {
			return new ResponseEntity<UserDetails>(userDetailsOpt.orElse(null), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDetails>(userDetailsOpt.get(), HttpStatus.OK);
	}
	
	@GetMapping("jpa/hateoas/users-details/{id}")
	public EntityModel<UserDetails> getUserDetailsByHateoas(@PathVariable("id") Integer id) {
		Optional<UserDetails> userDetailsOpt = userDetailsRepository.findById(id);
		if (!userDetailsOpt.isPresent() || userDetailsOpt.isEmpty()) {
			throw new UserNotFoundException("data not found for id = " + id);
		}
		EntityModel<UserDetails> entityModel = EntityModel.of(userDetailsOpt.get());
		WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(this.getClass()).getAllUserDetails());
		entityModel.add(webMvcLinkBuilder.withRel("all-users-details"));
		return entityModel;
	}

	@PostMapping("jpa/v1/users-details")
	public ResponseEntity<UserDetails> createUserDetailsV1(@Valid @RequestBody UserDetails userDetails) {
		UserDetails savedUserDetails = userDetailsRepository.save(userDetails);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUserDetails.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping("jpa/v2/users-details")
	public ResponseEntity<UserDetails> createUserDetailsV2(@Valid @RequestBody UserDetails userDetails) {
		UserDetails savedUserDetails = userDetailsRepository.save(userDetails);
		return new ResponseEntity<UserDetails>(savedUserDetails, HttpStatus.CREATED);
	}
	
	@DeleteMapping("jpa/v1/users-details/{id}")
	public String deleteUserDetails(@PathVariable("id") Integer id) {
		Optional<UserDetails> userDetailsOpt = userDetailsRepository.findById(id);
		if (!userDetailsOpt.isPresent() || userDetailsOpt.isEmpty()) {
			throw new UserNotFoundException("data not found for id = " + id);
		}
		userDetailsRepository.delete(userDetailsOpt.get());
		return "deleted";
	}
	
	@GetMapping("jpa/v1/users-details/{id}/designations")
	public List<Designation> getDesignationOfUser(@PathVariable("id") Integer id) {
		Optional<UserDetails> userDetailsOpt = userDetailsRepository.findById(id);
		if (!userDetailsOpt.isPresent() || userDetailsOpt.isEmpty()) {
			throw new UserNotFoundException("data not found for id = " + id);
		}
		return userDetailsOpt.get().getDesignations();
	}
	
	@PostMapping("jpa/v1/users-details/{id}/designations")
	public ResponseEntity<Object> createUserDetailsV1(@PathVariable("id") Integer id,
			@Valid @RequestBody Designation designation) {
		Optional<UserDetails> userDetailsOpt = userDetailsRepository.findById(id);
		if (!userDetailsOpt.isPresent() || userDetailsOpt.isEmpty()) {
			throw new UserNotFoundException("data not found for id = " + id);
		}
		designation.setUserDetails(userDetailsOpt.get());
		Designation savedDesignation = designationRepository.save(designation);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedDesignation.getDesignationId()).toUri();

		return ResponseEntity.created(location).build();
	}
}