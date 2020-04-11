package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;

@RestController
public class CrudControllers {

	@Autowired
	UserRepository userRep;
		
	
	// get all user
	@GetMapping("/user")
	public List<UserDetails> getUser() {
		return userRep.findAll();
	}
	
	
	// create new user
	@PostMapping("/user")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public UserDetails saveUser(@ModelAttribute("user") UserDetails userDet) {
		userDet.setRole("USER");
		return userRep.save(userDet);
	}
	

		
	// update user based on user id
	@PutMapping("/user")
	public UserDetails putUser(@RequestBody UserDetails userDet) {
		return userRep.save(userDet);
	}
	//delete user by id
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/user")
	public void deleteUserById(@RequestParam("id") int id) {
		userRep.deleteById(id);
	}
	
	
	
}
