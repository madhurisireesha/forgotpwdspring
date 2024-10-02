package com.auth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NavController {
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	@GetMapping("/openLoginPage")
	public String onLogin() {
		return "Login";
	}
	@GetMapping("/openSignUpPage")
	public String onSignUp() {
		return "SignUp";
	}
	@GetMapping("/openResetPassword")
	public String forgotPassword() {
		return "fgotpass";
	}
	
}
