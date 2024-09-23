package com.Task_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Task_Management_System.model.Task;

public interface TaskRepository  extends JpaRepository<Task, Long>{

}
