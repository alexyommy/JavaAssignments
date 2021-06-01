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
public class MainController {
	@Autowired
	private UserService uService;
	
	public Long userSession(HttpSession session) {
		if(session.getAttribute("userId") == null) { 
			return null;
		} 
		return (Long)session.getAttribute("userId"); }
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			System.out.println("User is not in session");
			return "redirect:/";
		}
		User user = uService.findUserById(userSession(session));
		
		model.addAttribute("user", user); 

		return "dashboard.jsp";
		
	}
}
