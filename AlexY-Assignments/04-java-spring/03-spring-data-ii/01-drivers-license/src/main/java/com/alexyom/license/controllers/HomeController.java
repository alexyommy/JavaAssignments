package com.alexyom.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alexyom.license.models.License;
import com.alexyom.license.models.Person;
import com.alexyom.license.services.DMVService;

@Controller
public class HomeController {
	private final DMVService service;
	public HomeController(DMVService serv) {
		this.service = serv;
	}
	@RequestMapping("/")
	public String Index(Model model) {
		List<Person> people = service.getPeople();
		model.addAttribute("persons", people);
		return "index.jsp";
	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String CreatePerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "newperson.jsp";
		}
		service.createPerson(person);
		return "redirect:/";
	}
	@RequestMapping("/{id}")
	public String ShowPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", service.getPerson(id));
		return "show.jsp";
	}
	@RequestMapping("/new")
	public String NewPerson(@ModelAttribute("person") Person person) {
		return "newperson.jsp";
	}
	@RequestMapping("/licenses/new")
	public String NewLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> unlicensed = service.getUnlicensedPeople();
		model.addAttribute("persons", unlicensed);
		return "newlicense.jsp";
	}
	@RequestMapping(value = "/licenses", method=RequestMethod.POST)
	public String CreateLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors())
			return "newlicense.jsp";
		service.createLicense(license);
		return "redirect:/";
	}
}
