package com.user.microservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.user.microservice.payloads.ApiResponse;

@ControllerAdvice
public class GlobalException {
	

	 @ExceptionHandler(NoSuchElementNotfound.class)
	    public ResponseEntity<ApiResponse<Object>> handleNoSuchElementFound(NoSuchElementNotfound ex) {
	        ApiResponse<Object> response = new ApiResponse<>();
	        response.setData("element not found");
	        response.setMessage(ex.getMessage());
	        response.setSuccess(false);
	        response.setStatus(HttpStatus.NOT_FOUND);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }

}
