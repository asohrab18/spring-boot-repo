package com.spring.boot.learnjpaandhibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.boot.learnjpaandhibernate.beans.Course;

@Component
public class CLRunnerForJpa implements CommandLineRunner {

	@Autowired
	private CourseJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		/*repository.insert(new Course(101L, "JPA", "Kaushik"));
		repository.insert(new Course(102L, "Angular", "Ranga"));
		repository.insert(new Course(103L, "Hibernate", "Naveen"));

		repository.deleteById(102L);

		System.out.println("\n\n\n--------------------------------------------------------------------------------\n"+repository.findById(101L));
		System.out.println(repository.findById(103L));*/
	}

}
