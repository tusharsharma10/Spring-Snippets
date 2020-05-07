package com.snippets.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.snippets.config.RegistrationForm;
import com.snippets.repository.UserRepository;
import com.snippets.service.RegisterService;

@Transactional
@Controller
public class LoginController {

	
	
	@Autowired RegisterService regService;
	
	@GetMapping("/")
	public String home() {
		
		return "home.html";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		
		return "register";
	}
	
//	@PostMapping("/login")
//	public String successLogin() {
//		
//		return "home";
//	}
	
	
	@PostMapping("/register")
	public String processRegistration(RegistrationForm form) {
		
		
		regService.saveUser(form);
		
		return "redirect:/login";
		
	}
	
}
