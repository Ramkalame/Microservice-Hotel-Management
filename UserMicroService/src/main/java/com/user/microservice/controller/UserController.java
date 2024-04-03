package com.user.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.microservice.exceptions.NoSuchElementNotfound;
import com.user.microservice.exceptions.UserNotFoundException;
import com.user.microservice.models.User;
import com.user.microservice.payloads.ApiResponse;
import com.user.microservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save-user")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		try {
			var savedUser = userService.saveUser(user);
			ApiResponse<Object> response = new ApiResponse<>(savedUser, HttpStatus.CREATED, true,
					"User saved successfully");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);

		} catch (NoSuchElementNotfound ex) {
			ApiResponse<User> errorResponse = new ApiResponse<>(null, HttpStatus.NOT_FOUND, false, ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}

	@GetMapping("/get-user-list")
	public ResponseEntity<?> getUserList() {
		try {

			var userlist = userService.getListUsers();
			ApiResponse<Object> response = new ApiResponse<Object>(userlist, HttpStatus.ACCEPTED, true,
					"here is a user list");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);

		} catch (NoSuchElementNotfound ex) {
			ApiResponse<Object> response = new ApiResponse<Object>(null, HttpStatus.NOT_FOUND, true, ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

		}

	}
	
	
	@GetMapping("/get-user/{userId}")
	public ResponseEntity<?> getUser(@PathVariable String userId){
		
		try {
			User existingUser = userService.getUser(userId);
			ApiResponse<Object> response = new ApiResponse<Object>(existingUser, HttpStatus.OK, true, "this is a user with this id : "+ userId);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(UserNotFoundException ex){
			ApiResponse<Object> response = new ApiResponse<Object>(null, HttpStatus.NOT_FOUND, true, ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);	
		}
		
	}

}
