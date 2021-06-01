package com.alexyom.springBootExample.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	// Declare the end point
	@RequestMapping("/")
	// method that maps the request route above
	public String hello() {
		return "Hello World!";
	}
	
}

