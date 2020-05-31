package com.nayek.employeemanagementapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/home")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

}
