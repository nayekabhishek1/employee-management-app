package com.nayek.employeemanagementapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("views/login");
		return mav;
	}

}
