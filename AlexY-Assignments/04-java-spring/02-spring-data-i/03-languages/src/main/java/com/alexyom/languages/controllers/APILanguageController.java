package com.alexyom.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexyom.languages.models.Language;
import com.alexyom.languages.services.LanguageService;

@RestController
@RequestMapping("/api")
public class APILanguageController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("")
	public List<Language> index() {
		return this.lService.getAllLanguages();
	}
	
	// To pull up specific object by id
	@GetMapping("/id")
	public Language getLanguage(@PathVariable("id") Long id) {
		return this.lService.getSingleLanguage(id);
	}
	
	//@RequestMapping("/value="/delete/{id}", method=RequestMethod.DELETE)
	@DeleteMapping(value="/delete/{id}")
	public void deleteLanguage(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
	}
	
	//@RequestMapping("/value="/update/{id}", method=RequestMethod.PUT)
	@PutMapping("/update/{id}")
	public Language updateLanguage(@PathVariable("id") Long id, Language updatedLanguage) {
		return this.lService.updateLanguage(updatedLanguage);
	}
}
