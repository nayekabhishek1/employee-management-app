package com.nayek.employeemanagementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayek.employeemanagementapp.entities.Task;
import com.nayek.employeemanagementapp.entities.User;
import com.nayek.employeemanagementapp.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public void addTaskToUser(Task task , User user)
	{
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task> findUserTasks(User user)
	{
		return taskRepository.findByUser(user);
	}

}
