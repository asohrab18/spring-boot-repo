package com.boot.spring.restfulwebservices.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(GreetingsController.class);
	
	private MessageSource messageSource;

	public GreetingsController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping("v1/hello")
	public String greet() {
		logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		return "Hello World!";
	}

	@GetMapping("v1/hello-bean")
	public Greeting greetByBean() {
		logger.info("An INFO Message");
		return new Greeting("Hello World!");
	}

	@GetMapping("v2/hello/{name}")
	public String greetUser(@PathVariable("name") String userName) {
		logger.info("An INFO Message");
		return "Hello " + userName + "!";
	}

	@GetMapping("i18n/hello")
	public String greetI18N() {
		logger.info("An INFO Message");
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("greeting.message", null, "Default Message", locale);
	}

	@GetMapping("message")
	public String getMessage() {
		logger.info("An INFO Message");
		return messageSource.getMessage("mail-body", null, null);
	}
}
