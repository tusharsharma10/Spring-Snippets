package com.snippets.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="User_Login")
public class User  {

	
	private static final long serialVersionUID = 1L;

	@Id
	private String username;
	
	
	private String password;
	
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public User() {
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	

	
	
	
	
}
