package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.UserDetails;

public interface UserService {
	public void validateAndUpdateUser(UserDetails userDet);

	public UserDetails save(UserDetails userDet);

	public List<UserDetails> findAll();

	public Optional<UserDetails> findById(int idInt);
}
