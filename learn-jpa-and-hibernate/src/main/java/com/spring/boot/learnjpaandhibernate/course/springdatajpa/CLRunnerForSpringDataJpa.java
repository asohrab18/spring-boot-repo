package com.spring.boot.learnjpaandhibernate.course.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.boot.learnjpaandhibernate.beans.Course;

@Component
public class CLRunnerForSpringDataJpa implements CommandLineRunner {

	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(101L, "JavaScript", "Ranga"));
		repository.save(new Course(102L, "Angular", "Kaushik"));
		repository.save(new Course(103L, "AWS", "Ranga"));

		repository.deleteById(102L);

		System.out.println("\n\n\n--------------------------------------------------------------------------------\n"+ repository.findById(101L).get());
		System.out.println(repository.findById(103L).get());
		System.out.println("\nAll Courses are: "+repository.findAll());
		System.out.println("\nTotal Results = "+repository.count());
		System.out.println("\nCourses of Ranga: "+repository.findByAuthor("Ranga"));
		System.out.println("\nCourses of Kaushik: "+repository.findByAuthor("Kaushik"));
		System.out.println("\nCourses by Name (JavaScript): "+repository.findByName("JavaScript"));
		System.out.println("\nCourses by Name (AWS): "+repository.findByName("AWS"));

		

	}
}
