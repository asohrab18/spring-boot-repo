package com.boot.spring.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.restfulwebservices.beans.Name;
import com.boot.spring.restfulwebservices.beans.PersonV1;
import com.boot.spring.restfulwebservices.beans.PersonV2;

@RestController
@RequestMapping("versioning")
public class VersioningController {

	@GetMapping("v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("John Cena");
	}

	@GetMapping("v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("John", "Cena"));
	}

	@GetMapping(path = "person", params = "version=1")
	public PersonV1 getPersonV1ByRequestParam() {
		return new PersonV1("Sachin Tendulkar");
	}

	@GetMapping(path = "person", params = "version=2")
	public PersonV2 getPersonV2ByRequestParam() {
		return new PersonV2(new Name("Sachin", "Tendulkar"));
	}
	
	@GetMapping(path = "header/person", headers = "X_API_VERSION=1")
	public PersonV1 getPersonV1ByRequestHeader() {
		return new PersonV1("Sachin Tendulkar");
	}
	
	@GetMapping(path = "header/person", headers = "X_API_VERSION=2")
	public PersonV2 getPersonV2ByRequestHeader() {
		return new PersonV2(new Name("Sachin", "Tendulkar"));
	}
	
	@GetMapping(path = "accept/person", produces = "application/www.rsystems.com-v1+json")
	public PersonV1 getPersonV1ByAcceptHeader() {
		return new PersonV1("Sachin Tendulkar");
	}
	
	@GetMapping(path = "accept/person", produces = "application/www.rsystems.com-v2+json")
	public PersonV2 getPersonV2ByAcceptHeader() {
		return new PersonV2(new Name("Sachin", "Tendulkar"));
	}
}