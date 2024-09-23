package com.Task_Management_System.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.Task_Management_System.enum1.TaskPriority;
import com.Task_Management_System.enum1.TaskStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Title is mandatory")
	private String title;

	@NotBlank(message = "Description is mandatory")
	private String description;

	@NotNull(message = "Due date is mandatory")
	private LocalDate dueDate;

	@Enumerated(EnumType.STRING)
	private TaskStatus status = TaskStatus.PENDING;

	@NotBlank(message = "Category is mandatory")
	private String category;

	@Enumerated(EnumType.STRING)
	private TaskPriority priority = TaskPriority.HIGH;

	@ManyToMany
    @JoinTable(
            name = "task_employee",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> assignedEmployees;

}
