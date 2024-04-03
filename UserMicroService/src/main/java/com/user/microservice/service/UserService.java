package com.user.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.user.microservice.models.User;

public interface UserService {
	
	
	
	public Object saveUser(User user);
	
	public List<User> getListUsers();
	
	public User getUser(String userId);
	
	public String deleteUser(String userId);
	
	

}
