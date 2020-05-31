package com.nayek.employeemanagementapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nayek.employeemanagementapp.entities.User;
import com.nayek.employeemanagementapp.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public ModelAndView registrationForm() {
		ModelAndView mav = new ModelAndView("views/registrationForm");
		mav.addObject("user", new User());
		return mav;
	}

	@PostMapping("/registration")
	public ModelAndView registrationSuccess(@Valid User user, BindingResult bindingResult) {
		ModelAndView mavFailure = new ModelAndView("views/registrationForm");
		if (bindingResult.hasErrors()) {
			//System.out.println(bindingResult.getAllErrors());
			return mavFailure;
		}

		if (userService.isUserExist(user.getEmail())) {
			mavFailure.addObject("userExist", true);
			return mavFailure;
		}

		userService.createUser(user);
		ModelAndView mavSuccess = new ModelAndView("views/registrationSuccess");
		return mavSuccess;

	}

}
