package com.lab21.Lab21Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	Person p;

	@RequestMapping("/")
	public ModelAndView page1() {
		return new ModelAndView("index", "test", "test");
	}
	
	@RequestMapping("/register")
	public ModelAndView page2() {
		return new ModelAndView("register", "test", "test");
	}
	
	@RequestMapping("/welcomeuser")
	public ModelAndView formTest(@RequestParam("fName") String firstName, @RequestParam("lName") String lastName) {
		p.setFirstName(firstName);
		p.setLastName(lastName);
		
		return new ModelAndView("welcome", "person", p.getFirstName());
	}
	
	@RequestMapping("/form") 
	public String form() {
		return "form";
	}
	
}
