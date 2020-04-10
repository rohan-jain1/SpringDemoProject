package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
	@Autowired
	private UserDetailsService userDet;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDet);
		
//		.inMemoryAuthentication()
//		.withUser("firstuser")
//		.password("{noop}userpass")
//		.roles("USER")
//		.and()
//		.withUser("admin")
//		.password("{noop}adminpass")
//		.roles("ADMIN");
//		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
//		web.
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
//		.antMatchers("/test**").permitAll()
//		.antMatchers("/login**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.logout()
		.logoutSuccessUrl("/logout");
		
		http.csrf().disable().cors().disable();
	}
	
	
	
}
