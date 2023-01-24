package com.boot.spring.restfulwebservices.beans;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("employeeFilter")
public class Employee {

	private String username;
	private String password;
	private String mobileNo;
	private Double salary;
	private LocalDateTime dob;

	public Employee() {
	}

	public Employee(String username, String password, String mobileNo, Double salary, LocalDateTime dob) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNo = mobileNo;
		this.salary = salary;
		this.dob = dob;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
}