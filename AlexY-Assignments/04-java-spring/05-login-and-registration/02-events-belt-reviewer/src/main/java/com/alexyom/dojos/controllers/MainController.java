package com.alexyom.dojos.controllers;



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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alexyom.dojos.models.Event;
import com.alexyom.dojos.models.State;
import com.alexyom.dojos.models.User;
import com.alexyom.dojos.services.EventService;
import com.alexyom.dojos.services.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService uService;
	@Autowired
	private EventService eService;
	
	public Long userSession(HttpSession session) {
		if(session.getAttribute("userId") == null) { 
			return null;
		} 
		return (Long)session.getAttribute("userId"); }
	
	//Home Page
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			System.out.println("User is not in session");
			return "redirect:/";
		}
		User user = uService.findUserById(userSession(session));
		
		model.addAttribute("user", user); 
		model.addAttribute("InState", eService.allEventsWithState(user.getState()));
		model.addAttribute("OutState", eService.allEventsNotState(user.getState()));
		model.addAttribute("states", State.States);

		return "dashboard.jsp";
	}
	
	//Add Event
	@PostMapping("/add")
	public String create(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			User user = uService.findUserById(userSession(session));
			model.addAttribute("user", user);
			model.addAttribute("InState", eService.allEventsWithState(user.getState()));
			model.addAttribute("OutState", eService.allEventsNotState(user.getState()));
			model.addAttribute("states", State.States);
			
			return "dashboard.jsp";
			
		} else {
		
		this.eService.create(event);
		return "redirect:/dashboard";
		}
	}
	
	//Delete Event
	@PostMapping("events/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		eService.delete(id);
		return "redirect:/dashboard";
	}
	
	//Show Event
	@GetMapping("events/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = this.userSession(session);
		Event event = this.eService.findById(id);
		
		if(userId == null)
			return "redirect:/";
		if(event == null)
			return "redirect:/dashboard";
		
		User user = this.uService.findUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("event", event);
		model.addAttribute("userId", userId);
		return "show.jsp";
	}
	
	//Join Event
	@PostMapping("events/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Event event = eService.findById(id);
		User user = uService.findUserById(userSession(session));
		if(event.getId() == null || userSession(session) == null) {
			return "redirect:/";
		}
		if(event.getAttendees().contains(user)) {
			return "redirect:/dashboard";
		}
		eService.addAttendee(event, user);
		return "redirect:/dashboard";
	}
	
	//Leave Event
	@PostMapping("events/{id}/remove")
	public String leaveEvent(@PathVariable("id") Long id, HttpSession session) {
		Event event = eService.findById(id);
		User user = uService.findUserById(userSession(session));
		if(event.getId() == null || userSession(session) == null) {
			return "redirect:/";
		}
		if(!event.getAttendees().contains(user)) {
			return "redirect:/dashboard";
		}
		eService.removeAttendee(event, user);
		return "redirect:/dashboard";
	}
	
	//Comment on Event
	@PostMapping("events/{id}/comment")
	public String comment(@PathVariable("id") Long id, @RequestParam("comment") String comment, RedirectAttributes redirs, HttpSession session) {
		Long userId = this.userSession(session);
		if(userId == null) {
			return "redirect:/";
		}
		if(comment.equals("")) {
			redirs.addFlashAttribute("error", "Comment must not be blank");
			return "redirect:/events/" + id ;
		}
		Event event = this.eService.findById(id);
		User author = this.uService.findUserById(userId);
		this.eService.comment(author, comment, event);
		return "redirect:/events/" + id;
	}
	
	//Show Edit Page
	@GetMapping("events/{id}/edit")
	public String editPage(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = this.userSession(session);
		Event editEvent = this.eService.findById(id);
		if(userId == null) {
			return "redirect:/";
		}
		if(editEvent == null || !editEvent.getPlanner().getId().equals(userId)) {
			return "redirect:/dashboard";
		}
		model.addAttribute("user", userId);
		model.addAttribute("event", editEvent);
		model.addAttribute("states", State.States);
		return "edit.jsp";
	}
	
	//Edit Event
	@PostMapping("events/{id}/editEvent")
	public String update(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = this.userSession(session);
		if(userId == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			Event editEvent = this.eService.findById(id);
			model.addAttribute("user", userId);
			model.addAttribute("event", editEvent);
			model.addAttribute("states", State.States);
			return "edit.jsp";
			
		} else {
			
			this.eService.update(event);
			return "redirect:/dashboard";
		}
	}
	
	//Delete Comment
	@PostMapping("message/{id}/delete")
	public String deleteComment(@PathVariable("id") Long id) {
		eService.deleteComment(id);
		return "redirect:/dashboard";
	}
}
