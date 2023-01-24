package com.boot.spring.restfulwebservices.beans;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class User {

	private Integer id;
	
	@Size(min = 2, message = "Name should have atleast 2 characters.")
	@JsonProperty("user_name")
	private String name;
	
	@PastOrPresent(message = "Birth Date should be in the past or present.")
	@JsonProperty("date_of_birth")
	private LocalDateTime birthDate;

	public User() {
	}

	public User(Integer id, String name, LocalDateTime birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
}