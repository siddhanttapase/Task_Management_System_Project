package com.Task_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Task_Management_System.exception.ResourceNotFoundException;
import com.Task_Management_System.model.Task;
import com.Task_Management_System.repository.TaskRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

	private TaskRepository taskRepository;

	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Task> getAllTasks() {
		log.info("Fetching all tasks");

		return taskRepository.findAll();
	}

	@Override
	public Task getTaskById(Long id) {
		log.info("Fetch Task with Id: {} " + id);
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found with ID: " + id));
		return task;
	}

	@Override
	public Task createTask(Task task) {

		log.info("Creating new task with title: {}" + task.getTitle());

		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Long id, Task task) {
		log.info("Updating Task with ID: {} " + id);
		Task exectingTask = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found with ID: " + id));
		exectingTask.setTitle(task.getTitle());
		exectingTask.setDescription(task.getDescription());
		exectingTask.setDueDate(task.getDueDate());
		exectingTask.setStatus(task.getStatus());
		exectingTask.setCategory(task.getCategory());
		exectingTask.setPriority(task.getPriority());
		exectingTask.setAssignedEmployees(task.getAssignedEmployees());
		log.debug("Task Update Sucessfully: {} " + task);

		return taskRepository.save(exectingTask);
	}

	@Override
	public void deleteTask(Long id) {
		log.info("Deleting Task with Id: {} " + id);
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found with ID: " + id));
		taskRepository.delete(task);
	}

}
