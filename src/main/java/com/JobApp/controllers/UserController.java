package com.JobApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JobApp.models.User;
import com.JobApp.services.JwtService;
import com.JobApp.services.UserService;




@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("register")
	public User addUser(@RequestBody User user) {
		userService.addUser(user);
		return user;
	}
	
	@PostMapping("login")
	public String loginUser(@RequestBody User user) {
		Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUserName());
		}
		return "Login Failed";
	}

}
