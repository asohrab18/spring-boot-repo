package com.boot.spring.restfulwebservices.controllers;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.restfulwebservices.beans.Greeting;

@RestController
@RequestMapping("greetings")
public class GreetingsController {

	private MessageSource messageSource;

	public GreetingsController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

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

	@GetMapping("i18n/hello")
	public String greetI18N() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("greeting.message", null, "Default Message", locale);
	}
}
