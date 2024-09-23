package com.Task_Management_System.service;

import java.util.List;

import com.Task_Management_System.model.Task;

public interface TaskService {

	List<Task> getAllTasks();

	Task getTaskById(Long id);

	Task createTask(Task task);

	Task updateTask(Long id, Task task);

	void deleteTask(Long id);

}
