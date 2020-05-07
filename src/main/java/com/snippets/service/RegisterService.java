package com.snippets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.snippets.config.RegistrationForm;
import com.snippets.repository.UserRepository;

@Service
public class RegisterService {
	@Autowired UserRepository userRepo;
	@Autowired PasswordEncoder passwordEncoder;
	
	public void saveUser(RegistrationForm form) {
		
		userRepo.save(form.toUser(passwordEncoder));
	}
	
}
