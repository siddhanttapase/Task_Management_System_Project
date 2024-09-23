package com.Task_Management_System.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Task_Management_System.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	List<Employee> findByNames(String name);
//	
//	Employee findByName(String name);

}
