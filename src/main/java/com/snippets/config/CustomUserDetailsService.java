package com.snippets.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.snippets.entity.User;
import com.snippets.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username);
		
		if(user!=null)
			return new CustomUserDetails(user);
		
		throw new UsernameNotFoundException("User with "+username+" not found");
		
	}

	
}
