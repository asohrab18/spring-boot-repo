package com.boot.spring.restfulwebservices.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.restfulwebservices.beans.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("filtering")
public class FilteringController {

	@GetMapping("bean")
	public MappingJacksonValue filteringOfBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("someBeanFilter", simpleBeanPropertyFilter);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}

	@GetMapping("bean-list")
	public MappingJacksonValue filteringListOfBean() {
		List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"),
				new SomeBean("value7", "value8", "value9"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeanList);
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("someBeanFilter", simpleBeanPropertyFilter);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
}
