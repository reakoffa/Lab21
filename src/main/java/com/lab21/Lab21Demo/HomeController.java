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
	public ModelAndView formTest(@RequestParam("uName") String userName, @RequestParam("fName") String firstName, @RequestParam("lName") String lastName,
			@RequestParam("password") String password, @RequestParam("email") String email) {
		Person p = new Person(userName, firstName, lastName, password, email);
		userDao.addUser(p);
		
		return new ModelAndView("successful", "person", p);
	}
	@RequestMapping("/loggedin") 
	public ModelAndView login(@RequestParam("uName") String username, @RequestParam("password") String password) {
		boolean b = userDao.checkUser(username, password);
		if (b == true) {
			return new ModelAndView("congrats");
		} else {
			return new ModelAndView("fail");
		}
	}
	
	@RequestMapping("/products") 
	public ModelAndView products() {
		List<items> items = userDao.findAll();
		
		return new ModelAndView("items", "item", items);
	}
	@RequestMapping("/login") 
	public ModelAndView login() {
		
		return new ModelAndView("login");
	}
	
}
