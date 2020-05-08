package com.snippets.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.snippets.config.RegistrationForm;
import com.snippets.entity.User;
import com.snippets.repository.UserRepository;
import com.snippets.service.RegisterService;


@Transactional
@Controller
public class LoginController {

	
	
	@Autowired RegisterService regService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<User> userList = regService.getAllUsers();
		model.addAttribute("userList",userList);
		
		model.addAttribute("curUser",regService.getCurrentUser());
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
	

	
	
	@PostMapping("/register")
	public String processRegistration(RegistrationForm form) {
		
		
		regService.saveUser(form);
		
		return "redirect:/login";
		
	}
	
}
