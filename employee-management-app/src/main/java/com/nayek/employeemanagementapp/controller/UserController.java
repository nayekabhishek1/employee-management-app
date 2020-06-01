package com.nayek.employeemanagementapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nayek.employeemanagementapp.entities.User;
import com.nayek.employeemanagementapp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ModelAndView getAllUsers(@RequestParam(defaultValue = "") String name) {
		ModelAndView mav = new ModelAndView("views/allUsers");
		List<User> userList = new ArrayList<User>();
		userList = findByName(name);
		mav.addObject("userList", userList);
		return mav;
	}

	/*
	 * public List<User> findAllUsers() { return userService.findAllUsers(); }
	 */

	public List<User> findByName(String name) {
		return userService.findUserByName(name);
	}
}
