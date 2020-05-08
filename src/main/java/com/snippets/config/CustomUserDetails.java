package com.snippets.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.snippets.entity.User;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
	public List<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> l1 = new ArrayList<GrantedAuthority>();
		l1.add(new SimpleGrantedAuthority(this.user.getRole()));
		return l1;
    }
	

	@Override
	public String getPassword() {
		
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
