package com.alexyom.dojos.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alexyom.dojos.models.Dojo;
import com.alexyom.dojos.models.Ninja;
import com.alexyom.dojos.services.DojoService;

@Controller
@RequestMapping("/")
public class HomeController {
	private final DojoService appService;
	public HomeController(DojoService service) {
		this.appService = service;
	}
	
	@RequestMapping("/")
	public String Index(Model model) {
		model.addAttribute("dojos",appService.allDojos());
		return "dojos.jsp";
	}
	
	@RequestMapping("ninjas")
	public String ninjaIndex(Model model) {
		model.addAttribute("ninjas", this.appService.allNinjas());
		return "ninjas.jsp";
	}
	
	@RequestMapping("ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", this.appService.allDojos());
		return "newNinja.jsp";
	}
	
	@RequestMapping(value="ninjas", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", this.appService.allDojos());
			return "newNinja.jsp";
		}
		this.appService.createNinja(ninja);
		return "redirect:/ninjas";
	}
	
	@RequestMapping("dojos")
	public String dojoIndex(Model model) {
		model.addAttribute("dojos",appService.allDojos());
		return "dojos.jsp";
	}
	
	@RequestMapping("dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@RequestMapping(value="dojos", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		this.appService.createDojo(dojo);
		return "redirect:/dojos";
	}
	
	@RequestMapping("dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", this.appService.findDojo(id));
		return "show.jsp";
	}
}
