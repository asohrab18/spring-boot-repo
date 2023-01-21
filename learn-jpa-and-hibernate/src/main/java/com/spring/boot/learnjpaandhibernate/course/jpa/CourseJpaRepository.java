package com.spring.boot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.spring.boot.learnjpaandhibernate.beans.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.persist(course);
	}

	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}

	public void deleteById(Long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
