package com.Task_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task_Management_System.exception.EmployeeNotFoundException;
import com.Task_Management_System.model.Employee;
import com.Task_Management_System.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public Employee createEmployee(Employee employee) {
		log.info("Creating employee: {}", employee);
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		log.info("Fetching all employees");
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {
		log.info("Fetching employee with ID: {}", id);
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id : " + id));
		return employee;
	}

	public Employee updateEmployee(Long id, Employee employee) {
		log.info("Updating employee with ID: {}", id);
		Employee exestingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id : " + id));
		exestingEmployee.setName(employee.getName());
		exestingEmployee.setEmail(employee.getEmail());
		exestingEmployee.setTasks(employee.getTasks());

		return employeeRepository.save(exestingEmployee);
	}

	public void deleteEmployee(Long id) {
		log.info("Deleting employee with ID: {}", id);
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id : " + id));
		employeeRepository.delete(employee);
	}

//	public List<Employee> getEmployeesByName(String name) {
//		log.info("Fetching employees with name: {}", name);
//		return employeeRepository.findByNames(name);
//	}

//	@Override
//	public Employee getEmployeeByName(String name) {
//		log.info("Fetching employee with name: {}", name);
//		return employeeRepository.findByName(name);
//	}

}
