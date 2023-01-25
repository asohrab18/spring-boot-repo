package com.boot.spring.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.spring.restfulwebservices.beans.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Integer> {

}
