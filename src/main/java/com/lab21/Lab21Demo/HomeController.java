package com.lab21.Lab21Demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lab21.Lab21Demo.dao.userDao;
import com.lab21.Lab21Demo.entity.Items;
import com.lab21.Lab21Demo.entity.Users;

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
	
	@RequestMapping(value="/successful", method=RequestMethod.POST)
	public ModelAndView formTest(@RequestParam("uName") String userName, @RequestParam("fName") String firstName, @RequestParam("lName") String lastName,
			@RequestParam("password") String password, @RequestParam("email") String email) {
		Users p = new Users(userName, firstName, lastName, password, email);
		p = userDao.update(p);
		
		return new ModelAndView("successful", "person", p);
	}
	@RequestMapping(value="/loggedin", method=RequestMethod.POST) 
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
		List<Items> items = userDao.findAll();
		
		return new ModelAndView("items", "item", items);
	}
	@RequestMapping("/login") 
	public ModelAndView login() {
		
		return new ModelAndView("login");
	}
	
	@RequestMapping("/update") 
	public ModelAndView delete(@RequestParam("name") String uName) {
		Items I = userDao.findByItem(uName);
		return new ModelAndView("updForm","item", I);
	}
	
	@RequestMapping("/delete") 
	public ModelAndView update(@RequestParam("name") String uName) {
		userDao.deleteByItem(uName);
		return new ModelAndView("items");
	}
	
	@RequestMapping("/update/form") 
	public ModelAndView updated(@RequestParam("name") String uName, @RequestParam("description") String desc, @RequestParam("quantity") int quan, @RequestParam("price") double price) {
		Items I = new Items(uName, desc, quan, price);
		userDao.addItem(I);
		return new ModelAndView("redirect:/products");
	}
	
	@RequestMapping("/additem") 
	public ModelAndView delete(@RequestParam("name") String uName, @RequestParam("description") String desc, @RequestParam("quantity") int quan, @RequestParam("price") double price) {
		Items I = userDao.findByItem(uName);
		return new ModelAndView("updForm","item", I);
	}
	
}
