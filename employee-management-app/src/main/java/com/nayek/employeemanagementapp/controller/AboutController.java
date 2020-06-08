package com.nayek.employeemanagementapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

	@GetMapping("/about")
	public ModelAndView aboutMe()
	{
		ModelAndView mav = new ModelAndView("views/about");
		return mav;
	}
}
