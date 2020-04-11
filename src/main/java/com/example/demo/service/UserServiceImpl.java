package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRep;
		
	@Override
	public void validateAndUpdateUser(UserDetails userDet) throws BadRequestException { 
		
			if(userDet.getUserid()==0) {
				System.out.println("no id provided");
				throw new BadRequestException("No userid provided");
			}
			
			if(userDet.getEmail()==null) {
				throw new BadRequestException("No emailId provided"); 
			}
			
			userRep.save(userDet);
		
	}

	@Override
	public UserDetails save(UserDetails userDet) {
		return userRep.save(userDet);
		
	}

	@Override
	public List<UserDetails> findAll() {
		return userRep.findAll();
	}

	@Override
	public Optional<UserDetails> findById(int idInt) {
		return userRep.findById(idInt);
	}
	
}
