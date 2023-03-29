package com.spring.boot.learnspringboot;

import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("university")
public class CourseController {
	
	Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@GetMapping("courses")
	public List<Course> getCourses() {
		logger.info("An info Message");
		return Stream.of(new Course(1L, "Spring Boot", "Kaushik"), new Course(2L, "Microservices", "Ranga")).toList();
	}

}
