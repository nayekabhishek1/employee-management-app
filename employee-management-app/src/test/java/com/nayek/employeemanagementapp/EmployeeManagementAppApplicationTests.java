package com.nayek.employeemanagementapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nayek.employeemanagementapp.entities.Task;
import com.nayek.employeemanagementapp.entities.User;
import com.nayek.employeemanagementapp.service.TaskService;
import com.nayek.employeemanagementapp.service.UserService;

@SpringBootTest
class EmployeeManagementAppApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@BeforeEach
	public void initDB() {
		{
			User user1 = new User("user1", "user1@mail.com", "12345");
			userService.createUser(user1);
		}

		{
			User admin1 = new User("admin1", "admin1@mail.com", "12345");
			userService.createUser(admin1);
		}

		Task task1 = new Task("26/05/2020", "00:15", "10:15", "This is a test task");
		User user = userService.findUserByEmail("user1@mail.com");
		taskService.addTaskToUser(task1, user);
	}

	@Test
	public void testIfUserExist() {
		User user = userService.findUserByEmail("user1@mail.com");
		assertNotNull(user);
	}

	@Test
	public void testIfAdminExist() {
		User admin = userService.findUserByEmail("admin1@mail.com");
		assertEquals("admin1@mail.com", admin.getEmail());
	}

	@Test
	public void testIfTaskAssignedForUser() {
		User user = userService.findUserByEmail("user1@mail.com");
		List<Task> task = taskService.findUserTasks(user);
		assertNotNull(task);
	}

}
