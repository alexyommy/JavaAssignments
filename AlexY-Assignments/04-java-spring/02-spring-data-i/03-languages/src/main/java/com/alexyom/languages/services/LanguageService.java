package com.alexyom.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alexyom.languages.models.Language;
import com.alexyom.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository lRepo;
	
	public LanguageService(LanguageRepository repo) {
		this.lRepo = repo;
	}
	
	//Get All Languages
	public List<Language> getAllLanguages(){
		return this.lRepo.findAll();
	}
	
	// Get One Language or returns Null if Empty
	public Language getSingleLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	//Create a Language
	public Language createLanguage(Language newLanguage) {
		return this.lRepo.save(newLanguage);
	}
	
	//Update a Language
	public Language updateLanguage(Language language) {
		return this.lRepo.save(language);
	}
	
	//Delete a Language
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}
	
	//Create Language with HTML Forms
	public Language createLanguageHTML(String name, String creator, int version) {
		Language newLanguage = new Language(name, creator, version);
		return this.lRepo.save(newLanguage);
	}
}
