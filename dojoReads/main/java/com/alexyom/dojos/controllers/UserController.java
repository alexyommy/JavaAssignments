package com.alexyom.dojos.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alexyom.dojos.models.User;
import com.alexyom.dojos.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("user") User user, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		model.addAttribute("user", this.uService.findUserById(userId));
		return "dashboard.jsp";
		
	}
}
