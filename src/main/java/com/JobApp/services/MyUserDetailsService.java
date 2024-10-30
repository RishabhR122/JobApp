package com.JobApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.JobApp.models.User;
import com.JobApp.models.UserPrincipal;
import com.JobApp.repo.UserRepo;


@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("No such user");
		}
		return new UserPrincipal(user);
	}
	
	
	
	

}
