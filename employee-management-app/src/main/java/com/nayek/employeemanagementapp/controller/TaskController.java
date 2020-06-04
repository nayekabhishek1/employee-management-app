package com.nayek.employeemanagementapp.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nayek.employeemanagementapp.entities.Task;
import com.nayek.employeemanagementapp.entities.User;
import com.nayek.employeemanagementapp.service.TaskService;
import com.nayek.employeemanagementapp.service.UserService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private UserService userService;

	@GetMapping("/addTask")
	public ModelAndView showAddTaskForm(String email, HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("views/taskForm");
		httpSession.setAttribute("email", email);
		mav.addObject("task", new Task());
		return mav;
	}

	@PostMapping("/addTask")
	public ModelAndView taskFormSubmit(@Valid Task task, BindingResult bindingResult, HttpSession httpSession , RedirectAttributes redirectAttributes) {
		ModelAndView mavFailure = new ModelAndView("views/taskForm");
		if (bindingResult.hasErrors()) {

			return mavFailure;
		}

		String email = (String) httpSession.getAttribute("email");
		User user = userService.findUserByEmail(email);
		taskService.addTaskToUser(task, user);
		ModelAndView mavSuccess = new ModelAndView("redirect:/users");
		redirectAttributes.addFlashAttribute("message", "Successfully Added task for "+user.getName());
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return mavSuccess;
	}
}