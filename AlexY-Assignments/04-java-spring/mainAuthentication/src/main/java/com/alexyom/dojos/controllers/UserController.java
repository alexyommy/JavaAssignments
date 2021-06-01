package com.alexyom.dojos.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alexyom.dojos.models.User;
import com.alexyom.dojos.services.UserService;
import com.alexyom.dojos.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator validator;
	
	
	//Show Index Page
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	//Register User
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
		User newUser = this.userService.registerUser(user);
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
		}
	}
	
	//Login User
	@PostMapping("/login")
	public String login(@RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAtt, HttpSession session) {
		if(!this.userService.authenticateUser(email, password)) {
			redirectAtt.addFlashAttribute("loginError", "Invalid Email or Password");
			return "redirect:/";
		}
		User user = this.userService.findByEmail(email);
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
	}
	
	//Logout User
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
