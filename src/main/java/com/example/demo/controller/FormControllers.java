package com.example.demo.controller;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
public class FormControllers {

//	@Autowired
//	UserRepository userRep;

	@Autowired
	UserService userServ;
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/adduser")
	public String loginForm(ModelMap map) {
		map.addAttribute("user", new UserDetails());
		return "adduser";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/selectuser")
	public String selectuser() {
		return "selectuser";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PostMapping("/updateuser")
	public String updateuser(@RequestParam("id") String id, ModelMap map) {
		int idInt = Integer.parseInt(id);
		UserDetails user = userServ.findById(idInt).get();
		map.addAttribute("user", user);
		return "updateuser";
	}
	
//	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
//	@PutMapping("/putuser/")
//	public String putuser(ModelMap map) {
//		map.addAttribute("user", new UserDetails());
//		return "adduser";
//	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping({"/", "/crudoperations"})
	public String crudoperations(ModelMap map) {
		return "crudoperations";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/displayusers")
	public String displayuser(ModelMap map) {
		map.addAttribute("user", userServ.findAll());
		return "displayusers";
	}
	

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PostMapping("/addusercontroller")
	public String addUser(@ModelAttribute("user") UserDetails userDet, ModelMap map) {
		try {
			userServ.save(userDet);
			map.addAttribute("message", "successfully added user");
		} catch (Exception e) {
			map.addAttribute("message", "Unable To add the User");
		}
		return "adduser";
	}
	
	
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/deleteuser")
	public String deleteuser() {
		return "deleteuser";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/updateusercontroller")
	public String updateUser(@ModelAttribute("user") UserDetails userDet, ModelMap map) {
		
		try {
			userServ.validateAndUpdateUser(userDet);
			map.addAttribute("message", "successfully Updated user");
		} catch (BadRequestException e) {
			e.printStackTrace();
			map.addAttribute("message", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			map.addAttribute("message", "Unable To update the User");
		}
		
		return "updateuser";
	}
	
//	@GetMapping("/adduser")
//	public String loginForm() {
//		return "adduser";
//	}
	
	
	
}
