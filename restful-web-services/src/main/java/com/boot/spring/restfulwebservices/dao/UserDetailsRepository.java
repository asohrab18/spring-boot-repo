package com.boot.spring.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.spring.restfulwebservices.beans.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

}
