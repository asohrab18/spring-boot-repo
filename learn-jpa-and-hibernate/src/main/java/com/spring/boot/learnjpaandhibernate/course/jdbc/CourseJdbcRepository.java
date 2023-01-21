package com.spring.boot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.boot.learnjpaandhibernate.beans.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY = "Insert into COURSE (id, name, author) values(?,?,?);";

	private static String DELETE_QUERY = "Delete From COURSE WHERE id = ?;";

	private static String SELECT_QUERY = "Select * From COURSE WHERE id = ?;";

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(Long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}

	public Course findById(Long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
