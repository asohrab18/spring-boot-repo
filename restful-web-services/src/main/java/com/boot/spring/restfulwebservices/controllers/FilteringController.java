package com.boot.spring.restfulwebservices.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.restfulwebservices.beans.SomeBean;

@RestController
@RequestMapping("filtering")
public class FilteringController {

	@GetMapping("bean")
	public SomeBean filteringOfBean() {
		return new SomeBean("value1", "value2", "value3");
	}

	@GetMapping("bean-list")
	public List<SomeBean> filteringListOfBean() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"),
				new SomeBean("value7", "value8", "value9"));
	}
}
