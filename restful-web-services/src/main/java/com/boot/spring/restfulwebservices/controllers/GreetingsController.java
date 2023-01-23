package com.boot.spring.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.restfulwebservices.beans.Greeting;

@RestController
@RequestMapping("greetings")
public class GreetingsController {

	@GetMapping("v1/hello")
	public String greet() {
		return "Hello World!";
	}

	@GetMapping("v1/hello-bean")
	public Greeting greetByBean() {
		return new Greeting("Hello World!");
	}

	@GetMapping("v2/hello/{name}")
	public String greetUser(@PathVariable("name") String userName) {
		return "Hello " + userName + "!";
	}
}
