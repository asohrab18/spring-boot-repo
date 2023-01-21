package com.spring.boot.learnspringboot;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("university")
public class CourseController {

	@GetMapping("courses")
	public List<Course> getCourses() {
		return Stream.of(new Course(1L, "Spring Boot", "Kaushik"), new Course(2L, "Microservices", "Ranga")).toList();
	}

}
