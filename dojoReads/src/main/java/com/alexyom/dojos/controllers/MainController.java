package com.alexyom.dojos.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexyom.dojos.models.Review;
import com.alexyom.dojos.models.User;
import com.alexyom.dojos.services.ReviewService;
import com.alexyom.dojos.services.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService uService;
	@Autowired
	private ReviewService rService;
	
	public Long userSession(HttpSession session) {
		if(session.getAttribute("user_id") == null) { 
			return null;
		} 
		return (Long)session.getAttribute("user_id"); }
	
	//Home Page
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("review") Review review, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			System.out.println("User is not in session");
			return "redirect:/";
		}
		User user = uService.findUserById(userSession(session));
		model.addAttribute("user", user);
		model.addAttribute("reviews", rService.getReviews());
		return "dashboard.jsp";
	}
	
	//Add Review
	@PostMapping("/add")
	public String create(@Valid @ModelAttribute("review") Review review, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			User user = uService.findUserById(userSession(session));
			model.addAttribute("user", user);
			return "dashboard.jsp";
			
		} else {
		
		this.rService.create(review);
		return "redirect:/dashboard";
		}
	}
}
