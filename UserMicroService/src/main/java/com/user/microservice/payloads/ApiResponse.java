package com.user.microservice.payloads;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
	
	private T data;
	private HttpStatus status;
	private boolean success; 
	private String message;

}
