package com.user.microservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.microservice.exceptions.NoSuchElementNotfound;
import com.user.microservice.exceptions.UserNotFoundException;
import com.user.microservice.models.User;
import com.user.microservice.repositories.UserRepository;
import com.user.microservice.service.UserService;


@Service 
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Object saveUser(User user) {
		User newUser = new User();
		if(user.getUserId() != null) {
		newUser.setName(user.getName());
		newUser.setUserId(user.getUserId());
		newUser.setAddress(user.getAddress());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		userRepo.save(newUser);
		return newUser;
		}else {
			throw new NoSuchElementNotfound("601", "user id is empty");
		}
	}

	@Override
	public List<User> getListUsers() {
		List<User> listOfuser = userRepo.findAll();
		if(listOfuser.isEmpty()) {
			throw new NoSuchElementNotfound("602", "there is no user present in the databse");
			
		}else {
			return listOfuser;
		}
		
	}

	@Override
	public User getUser(String userId) {
		User existingUser = userRepo.findById(userId).get();
		if(existingUser != null) {
			return existingUser;
		}else {
			throw new UserNotFoundException("603", "User not found with this id "+ userId);
		}
		
	}

	@Override
	public String deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
