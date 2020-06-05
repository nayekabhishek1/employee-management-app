package com.nayek.employeemanagementapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nayek.employeemanagementapp.entities.Task;
import com.nayek.employeemanagementapp.entities.User;
import com.nayek.employeemanagementapp.service.TaskService;
import com.nayek.employeemanagementapp.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/profile")
	public ModelAndView showProfile(Principal principal)
	{
		ModelAndView mav = new ModelAndView("views/profile");
		String email = principal.getName();
		System.out.println("************************"+email);
		User user = userService.findUserByEmail(email);
		List<Task> tasks = taskService.findUserTasks(user);
		mav.addObject("tasks", tasks);
		return mav;
	}

}
