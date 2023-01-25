package com.boot.spring.restfulwebservices.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Designation {

	@Id
	@GeneratedValue
	private Integer designationId;

	@Size(min = 10)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserDetails userDetails;

	public Designation() {
	}

	public Designation(Integer designationId, String description, UserDetails userDetails) {
		super();
		this.designationId = designationId;
		this.description = description;
		this.userDetails = userDetails;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}