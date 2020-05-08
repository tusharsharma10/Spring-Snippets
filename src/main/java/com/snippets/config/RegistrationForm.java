package com.snippets.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.snippets.entity.User;

public class RegistrationForm {

	private String username;
	private String password;
	
	
	
	
	public RegistrationForm(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	
	
	
	public RegistrationForm() {
	}


public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public User toUser(PasswordEncoder passwordEncoder) {
	
		return new User(username, passwordEncoder.encode(password),"USER");
	}
	
	
	
}
