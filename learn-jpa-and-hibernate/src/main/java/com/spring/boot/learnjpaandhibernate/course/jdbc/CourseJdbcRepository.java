package com.spring.boot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	public void insert() {
		springJdbcTemplate.update("Insert into COURSE (id, name, author) values(1, 'Spring Boot and Microservices', 'Ranga');");
	}
}
