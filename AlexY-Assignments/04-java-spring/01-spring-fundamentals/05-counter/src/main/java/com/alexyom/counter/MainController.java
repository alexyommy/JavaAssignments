package com.alexyom.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private int getSessionCount(HttpSession sesh) {
		Object seshVal = sesh.getAttribute("count");
		if(seshVal == null) {
			setSessionCount(sesh, 0);
			seshVal = sesh.getAttribute("count");
		}
		return (Integer)seshVal;
	}
	private void setSessionCount(HttpSession sesh, int val) {
		sesh.setAttribute("count", val);
	}
	@RequestMapping("/")
	public String Index(HttpSession s) {
		int currCount = getSessionCount(s);
		setSessionCount(s, ++currCount);
		return "index.jsp";
	}
	@RequestMapping("/add/{times}")
	public String Add(@PathVariable("times") String times, HttpSession s) {
		int t = 1;
		try {
			t = Integer.parseInt(times);
		}
		catch(NumberFormatException e) {
			System.out.println(String.format("Exception Thrown %s", e.getMessage()));
			return "redirect:/";
		}
		int currCount = getSessionCount(s);
		currCount += t;
		setSessionCount(s, currCount);
		return "index.jsp";
	}
	@RequestMapping("/reset")
	public String Reset(HttpSession s) {
		s.invalidate();
		return "redirect:/counter";
	}
	@RequestMapping("/counter")
	public String Counter(HttpSession s, Model model) {
		model.addAttribute("count", getSessionCount(s));
		return "count.jsp";
		
	}
}