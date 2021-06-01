package com.alexyom.languages.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alexyom.languages.models.Language;
import com.alexyom.languages.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<Language> allLanguages = this.lService.getAllLanguages();
		viewModel.addAttribute("languages", allLanguages);
		return "index.jsp";
	}
	
	@GetMapping("/add")
	public String addLanguage(@ModelAttribute("language") Language language) {
		return "New.jsp";
	}
	
	@PostMapping("/add")
	public String newLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "New.jsp";
		}
		this.lService.createLanguage(language);
		return "redirect:/";
	}
	 
	@PostMapping("/addHTMLWay")
	public String newLanguageHTML(@RequestParam("name") String name, @RequestParam("creator") String creator, @RequestParam("version") int version, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("Name Field must be entered.");
		}
		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/add";
		}
		this.lService.createLanguageHTML(name, creator, version);
		return "redirect:/";
	}
}
