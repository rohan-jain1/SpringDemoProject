package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;

@Controller
public class CrudControllers {

	@Autowired
	UserRepository userRep;
	
	@ResponseBody
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/role_user")
	public String role_user() {
		return "role_user";
	}
	
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/role_admin")
	public String role_admin() {
		return "role_admin";
	}

	@ResponseBody
	@GetMapping("/gettest")
	public String gettest() {
		return "gettest";
	}
	
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/DeleteUserById/{uid}")
	public void deleteUser2(@PathVariable int uid) {
		userRep.deleteById(uid);
	}
	
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/UserById/{uid}")
	public void deleteUser(@PathVariable int uid) {
		userRep.deleteById(uid);
	}

	
	@ResponseBody
	@GetMapping("/userByEmail/{email}")
	public UserDetails getUserByEmail(@PathVariable String email) {
		return userRep.findByEmail(email);
	}
	
	
	
	
	
	@ResponseBody
	@GetMapping("/user")
	public List<UserDetails> getUser() {
		return userRep.findAll();
	}
	
	@ResponseBody
	@GetMapping("/user/{userid}")
	public UserDetails getUser(@PathVariable int userid) {
		return userRep.findById(userid).get();
	}
	
	@ResponseBody
	@PostMapping("/user")
	public UserDetails saveUser(@ModelAttribute("user") UserDetails userDet) {
		return userRep.save(userDet);
	}

	@ResponseBody
	@PutMapping("/user/{userid}")
	public UserDetails putUser(@PathVariable int userid, @RequestBody UserDetails userDet) {
		return userRep.save(userDet);
	}
	
	@ResponseBody
	@DeleteMapping("/deleteuser")
	public void deleteUserById(@RequestParam("id") int id) {
		userRep.deleteById(id);
	}
	
}
