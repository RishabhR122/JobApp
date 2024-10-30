package com.JobApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.JobApp.models.User;
import com.JobApp.repo.UserRepo;


@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

	public void addUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
	}
	
	
	
}
