package com.JobApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobApp.models.User;



@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByUserName(String userName);

}
