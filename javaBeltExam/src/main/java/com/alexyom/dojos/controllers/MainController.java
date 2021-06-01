package com.alexyom.dojos.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexyom.dojos.models.Task;
import com.alexyom.dojos.models.User;
import com.alexyom.dojos.services.TaskService;
import com.alexyom.dojos.services.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService uService;
	@Autowired
	private TaskService tService;
	
	public Long userSession(HttpSession session) {
		if(session.getAttribute("userId") == null) { 
			return null;
		} 
		return (Long)session.getAttribute("userId"); }
	
	//Home Page
	@GetMapping("/tasks")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			System.out.println("User is not in session");
			return "redirect:/";
		}
		User user = uService.findUserById(userSession(session));
		
		model.addAttribute("user", user); 
		model.addAttribute("tasks", tService.getTasks());
		return "dashboard.jsp";
		
	}
	
	//Add Page
	@GetMapping("/tasks/new")
	public String addPage(@ModelAttribute("task") Task task, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			System.out.println("User is not in session");
			return "redirect:/";
		}
		User user = uService.findUserById(userSession(session));
		
		model.addAttribute("user", user); 
		model.addAttribute("assignees", uService.findAll());

		return "new.jsp";
	}
	
	//Add Task
	@PostMapping("/add")
	public String create(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			User user = uService.findUserById(userSession(session));
			model.addAttribute("user", user);
			model.addAttribute("assignees", uService.findAll());
			return "new.jsp";
			
		} else {
		
		this.tService.create(task);
		return "redirect:/tasks";
		}
	}
	
	//Show Task
	@GetMapping("tasks/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = this.userSession(session);
		Task task = this.tService.findById(id);
		
		if(userId == null)
			return "redirect:/";
		if(task == null)
			return "redirect:/tasks";
		
		User user = this.uService.findUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("task", task);
		model.addAttribute("userId", userId);
		return "show.jsp";
	}
	
	//Delete Task
	@PostMapping("tasks/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		tService.delete(id);
		return "redirect:/tasks";
	}
	
	//Complete Task
	@PostMapping("tasks/{id}/complete")
	public String complete(@PathVariable("id") Long id) {
		tService.complete(id);
		return "redirect:/tasks";
	}
	
	//Show Edit Page
	@GetMapping("tasks/{id}/edit")
	public String editPage(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = this.userSession(session);
		Task editTask = this.tService.findById(id);
		if(userId == null) {
			return "redirect:/";
		}
		if(editTask == null || !editTask.getCreator().getId().equals(userId)) {
			return "redirect:/tasks";
		}
		model.addAttribute("user", userId);
		model.addAttribute("assignees", uService.findAll());
		model.addAttribute("task", editTask);
		return "edit.jsp";
	}
	
	//Edit Event
	@PostMapping("tasks/{id}/editTask")
	public String update(@Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = this.userSession(session);
		if(userId == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			Task editTask = this.tService.findById(id);
			model.addAttribute("user", userId);
			model.addAttribute("assignees", uService.findAll());
			model.addAttribute("task", editTask);
			return "edit.jsp";
			
		} else {
			
			this.tService.update(task);
			return "redirect:/tasks";
		}
	}
	
	//High to Low Page
	@GetMapping("/hightolow")
	public String highToLow(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			System.out.println("User is not in session");
			return "redirect:/";
		}
		User user = uService.findUserById(userSession(session));
		
		model.addAttribute("user", user); 
		model.addAttribute("tasks", tService.getTasks());
		return "htol.jsp";
		
	}
	//High to Low Page
	@GetMapping("/lowtohigh")
	public String lowToHigh(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			System.out.println("User is not in session");
			return "redirect:/";
		}
		User user = uService.findUserById(userSession(session));
		
		model.addAttribute("user", user); 
		model.addAttribute("tasks", tService.getTasks());
		return "ltoh.jsp";
		
	}
}
