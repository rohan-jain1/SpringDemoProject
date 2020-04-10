package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;


@Service  //("userDet")
public class UserDetailsServiceImpl implements UserDetailsService{

	
	@Autowired
	UserRepository userRep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.model.UserDetails userDet = userRep.findByEmail(username);
		
		
		UserBuilder builder = User.withUsername(username);
		
		builder
		.username(userDet.getEmail())
		.password("{noop}"+userDet.getPassword())
//		.authorities(userDet.getRole())
		.roles(userDet.getRole());
		
//		UserDetails securityUserDetails
//		se
//		
		return builder.build();
		
//		return User.withUsername(userDet.getEmail()).password("{noop}"+userDet.getPassword()).roles(userDet.getRole()).build();
	}

}
