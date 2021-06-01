package com.alexyom.spring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexyom.spring.models.Answer;
import com.alexyom.spring.models.NewQuestion;
import com.alexyom.spring.models.Question;
import com.alexyom.spring.services.QuestionService;

@Controller
public class HomeController {
	@Autowired
	private QuestionService qService;
	
	//Home Page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", qService.getAllQuestions());
		return "index.jsp";
	}
	
	//Show New Question Page
	@GetMapping("/question")
	public String newQuestion(@ModelAttribute("newQuestion") NewQuestion newQuestion) {
		return "new.jsp";
	}
	
	//Add New Question
	@PostMapping("/question/new")
	public String addQuestion(@Valid @ModelAttribute("newQuestion") NewQuestion newQuestion, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
		this.qService.createQuestion(newQuestion);
		return "redirect:/";
		}
	}
	
	//Show Specific Question
	@GetMapping("/question/{id}")
	public String showQuestion(@PathVariable("id") Long id, @ModelAttribute("answerout") Answer answer, Model viewModel) {
		Question question = this.qService.getSingleQuestion(id);
		viewModel.addAttribute("question", question);
		return "show.jsp";
	}
	
	//Answer the Question
	@PostMapping("/answer")
	public String answerQuestion(@Valid @ModelAttribute("answerout") Answer answer, BindingResult result) {
		System.out.println(answer.getAnswer());
		if(result.hasErrors()) {
			return "show.jsp";
		} else {
		this.qService.createAnswer(answer);
		return "redirect:/";
		}
	}
}
