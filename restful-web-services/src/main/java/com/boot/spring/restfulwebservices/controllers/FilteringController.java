package com.boot.spring.restfulwebservices.controllers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.restfulwebservices.beans.Employee;
import com.boot.spring.restfulwebservices.beans.SomeBean;
import com.boot.spring.restfulwebservices.utilities.AppUtil;

@RestController
@RequestMapping("filtering")
public class FilteringController {

	@GetMapping("bean")
	public MappingJacksonValue filteringOfBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		String[] exceptFields = { "field1", "field2" };
		MappingJacksonValue mappingJacksonValue = AppUtil.filterDynamically(someBean, "someBeanFilter", exceptFields);
		return mappingJacksonValue;
	}

	@GetMapping("bean-list")
	public MappingJacksonValue filteringListOfBean() {
		List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"), 
				new SomeBean("value7", "value8", "value9"));
		String[] exceptFields = { "field2", "field3" };
		MappingJacksonValue mappingJacksonValue = AppUtil.filterDynamically(someBeanList, "someBeanFilter", exceptFields);
		return mappingJacksonValue;
	}
	
	@GetMapping("employee")
	public MappingJacksonValue getEmployeeDetails() {
		Employee employee = new Employee("john123", "cena@007", "+91 9897123456",150000D,LocalDateTime.now().minusYears(30));
		String[] exceptFields = { "username", "mobileNo", "dob" };
		MappingJacksonValue mappingJacksonValue = AppUtil.filterDynamically(employee, "employeeFilter", exceptFields);
		return mappingJacksonValue;
	}
	
	@GetMapping("employees-list")
	public MappingJacksonValue getEmployeesList() {
		Employee employee1 = new Employee("john123", "cena@007", "+91 9897123456",150000D,LocalDateTime.now().minusYears(30));
		Employee employee2 = new Employee("ana987", "julie_231", "+61 8734562190",200000D,LocalDateTime.now().minusYears(60));
		List<Employee> employeesList = Arrays.asList(employee1, employee2);
		String[] exceptFields = { "username", "dob" };
		MappingJacksonValue mappingJacksonValue = AppUtil.filterDynamically(employeesList, "employeeFilter", exceptFields);
		return mappingJacksonValue;
	}
}
