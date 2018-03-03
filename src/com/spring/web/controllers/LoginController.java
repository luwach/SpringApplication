package com.spring.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.dao.User;
import com.spring.web.service.UsersService;

@Controller
public class LoginController {
	
	@Autowired
	private UsersService usersService;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	@RequestMapping("/createaccount")
	public String createAccount() {
		return "accountcreated";
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "createaccount";
		}
		
		user.setAuthority("user");
		user.setEnabled(true);
		
		usersService.create(user);
		
		return "accountcreated";
	}
}
