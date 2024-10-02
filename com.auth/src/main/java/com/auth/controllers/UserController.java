package com.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth.entities.User;
import com.auth.services.UserService;
@Controller
public class UserController {
	@Autowired
	UserService service;
	@PostMapping("/signUpUser")
	public String addUser(@ModelAttribute User user) {
		//check if username alresdy exists
		boolean status=service.usernameExists(user.getUsername());
		if(status==false) {
			service.addUser(user);
		}
		else {
			System.out.println("Username already exists");
			
		}
		return "Login";
	}
	@PostMapping("/loginUser")
	public String validateUser(@RequestParam String username,@RequestParam String password)
	{	System.out.println(username+" "+password);
		boolean status=service.validateUser(username,password);
		if(status==true) {
			return "home";
		}
		return "Login";
	}
	@PostMapping("/forgotPassword")
	public String processForgotPassword(@RequestParam String email,Model model) {
		User user=service.findByEmail(email);
		
		System.out.println(user);
		if(user!=null) {
			model.addAttribute("user",user);
			return "resetpassword";
		}
		return "SignUp";
	}
	@PostMapping("/resetPassword")
	public String resetPassword(@RequestParam String email,
			@RequestParam("password") String newPassword) {
		System.out.print(email+" "+newPassword);
		User user=service.findByEmail(email);
		if(user!=null) {
			service.updatePassword(user,newPassword);
			return "Login";
		}
		return "SignUp";
	}
	
	
	
}
