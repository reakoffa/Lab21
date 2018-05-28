package com.lab21.Lab21Demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lab21.entity.Person;
import com.lab21.entity.items;

@Controller
public class HomeController {
	
	@Autowired
	private userDao userDao;

	@RequestMapping("/")
	public ModelAndView page1() {
		return new ModelAndView("index", "test", "test");
	}
	
	@RequestMapping("/register")
	public ModelAndView page2() {
	
		
		return new ModelAndView("register", "test", "test");
	}
	
	@RequestMapping("/successful")
	public ModelAndView formTest(@RequestParam("fName") String firstName, @RequestParam("lName") String lastName) {
		Person p = new Person(firstName, lastName);
		userDao.addUser(p);
		
		return new ModelAndView("successful", "person", p.getFirstName());
	}
	
	@RequestMapping("/products") 
	public ModelAndView products() {
		List<items> items = userDao.findAll();
		
		return new ModelAndView("items", "item", items);
	}
	
}
