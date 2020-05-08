package com.snippets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.snippets.config.CustomUserDetails;
import com.snippets.config.RegistrationForm;
import com.snippets.entity.User;
import com.snippets.repository.UserRepository;

@Service
public class RegisterService {
	
	@Autowired UserRepository userRepo;
	@Autowired PasswordEncoder passwordEncoder;
	
	public void saveUser(RegistrationForm form) {
		
		userRepo.save(form.toUser(passwordEncoder));
	}
	
	
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
		
	}
	
	public String getCurrentUser() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {

		  String username = ((UserDetails)principal).getUsername();
		 // System.out.println(((UserDetails) principal).getAuthorities());
		  return username;
		} else {

		  String username = principal.toString();
		  return username;
		}
		
		
	}
	
}
