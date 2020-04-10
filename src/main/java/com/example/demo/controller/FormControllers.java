package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;

@Controller
public class FormControllers {

	@Autowired
	UserRepository userRep;

	
	
	@GetMapping("/adduser")
	public String loginForm(ModelMap map) {
		map.addAttribute("user", new UserDetails());
		return "adduser";
	}
	
	@GetMapping({"/", "/crudoperations"})
	public String crudoperations(ModelMap map) {
		return "crudoperations";
	}
	
	@GetMapping("/displayusers")
	public String displayuser(ModelMap map) {
		map.addAttribute("user", userRep.findAll());
		return "displayusers";
	}
	
	@GetMapping("/deleteuser")
	public String deleteuser() {
		return "deleteuser";
	}
	

	@PostMapping("/addusercontroller")
	public String addUser(@ModelAttribute("user") UserDetails userDet, ModelMap map) {
		userRep.save(userDet);
		map.addAttribute("message", "successfully added user");
		return "adduser";
	}
	
//	@GetMapping("/adduser")
//	public String loginForm() {
//		return "adduser";
//	}
	
	
	
}
