package com.Task_Management_System.service;

import java.util.List;


import com.Task_Management_System.model.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

	Employee createEmployee(@Valid Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	Employee updateEmployee(Long id, @Valid Employee employee);

	void deleteEmployee(Long id);

//	List<Employee> getEmployeesByName(String names);
//
//	Employee getEmployeeByName(String name);

	

	

}
