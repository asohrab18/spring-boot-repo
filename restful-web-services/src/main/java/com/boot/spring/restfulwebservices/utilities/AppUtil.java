package com.boot.spring.restfulwebservices.utilities;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class AppUtil {

	public static MappingJacksonValue filterDynamically(Object obj, String jsonFilterName, String[]exceptFields) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(obj);
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(exceptFields);
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(jsonFilterName, simpleBeanPropertyFilter);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}

}
