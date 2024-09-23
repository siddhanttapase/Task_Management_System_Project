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
import com.Task_Management_System.model.Task;
import com.Task_Management_System.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/tasks")
@Validated
@Slf4j
public class TaskController {

	private TaskService taskService;

	@Autowired
	public TaskController(TaskService service) {
		super();
		this.taskService = service;
	}

	// get all task
	@Operation(summary = "Get all tasks", description = "Fetches a list of all tasks.")
	@GetMapping
	public List<Task> getAllTasks() {
		log.info("Received request to get all tasks");
		return taskService.getAllTasks();
	}

	// get task using ID
	@Operation(summary = "Get task by ID", description = "Fetch a specific task by providing its ID.")
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
		log.info("Received request to get task by ID: {} " + id);

		return new ResponseEntity<Task>(taskService.getTaskById(id), HttpStatus.OK);

	}

	// createTask
	@Operation(summary = "Create a new task", description = "This allows you to create a new task by providing task details.")
	@PostMapping
	public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
		log.info("Received request to create a new task");
		return new ResponseEntity<Task>(taskService.createTask(task), HttpStatus.CREATED);

	}

	// updateTask
	@Operation(summary = "Update a task", description = "This allows you to update the details of an existing task.")
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task task) {
		log.info("Received request to Update task with ID:{}" + id);
		return new ResponseEntity<Task>(taskService.updateTask(id, task), HttpStatus.OK);

	}

	@Operation(summary = "Delete a task", description = "This allows you to delete a task by providing its ID.")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return new ResponseEntity<String>("Task with ID " + id + " deleted successfully!", HttpStatus.OK);
	}

}
