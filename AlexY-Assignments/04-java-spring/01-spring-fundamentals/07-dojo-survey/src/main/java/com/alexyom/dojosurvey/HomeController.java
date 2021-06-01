package com.alexyom.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexyom.dojosurvey.models.Survey;

@Controller
public class HomeController {
	private String[] getLanguages() {
		return new String[] {
			"Python", "Java", "MERN", "C#"
		};
	}
	private String[] getLocations() {
		return new String[] {
			"Baltimore", "New York", "Seattle", "LA", "Austin"
		};
	}
	@RequestMapping("/")
	public String index(Model model ) {
		model.addAttribute("languages",getLanguages());
		model.addAttribute("locations",getLocations());
		return "index.jsp";
	}
	@RequestMapping(value="/survey", method=RequestMethod.POST)
	public String Results(
			@RequestParam(value="name") String name,
			@RequestParam(value="location") String location,
			@RequestParam(value="language") String language,
			@RequestParam(value="comment") String comment,
			Model model){
		model.addAttribute("result", new Survey(name,location,language,comment));
		return "result.jsp";
	}
			
			
}
