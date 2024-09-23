package com.Task_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Task_Management_System.model.Employee;
import com.Task_Management_System.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/employees")
@Validated
@Slf4j
public class EmployeeController {
   
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@Operation(summary = "Create a new employee", description = "This API creates a new employee.")
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(this.employeeService.createEmployee(employee), HttpStatus.CREATED);

	}

	@GetMapping
	@Operation(summary = "Get all employees", description = "This API retrieves all employees.")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(this.employeeService.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get an employee by ID", description = "This API retrieves an employee by their ID.")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return new ResponseEntity<Employee>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update an employee", description = "This API updates an existing employee.")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(this.employeeService.updateEmployee(id, employee), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete an employee", description = "This API deletes an employee by their ID.")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		this.employeeService.deleteEmployee(id);
		return new ResponseEntity("Employee with ID " + id + " deleted successfully!", HttpStatus.OK);
	}

//	@GetMapping("/name/{names}")
//	@Operation(summary = "Get employees by name", description = "This API retrieves employees by their name.")
//	public ResponseEntity<List<Employee>> getEmployeesByName(@PathVariable String names) {
//		return new ResponseEntity(employeeService.getEmployeesByName(names), HttpStatus.OK);
//	}
//	
//	@GetMapping("/name/{name}")
//	@Operation(summary = "Get employees by name", description = "This API retrieves employees by their name.")
//	public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {
//		return new ResponseEntity(employeeService.getEmployeeByName(name), HttpStatus.OK);
//	}

}
