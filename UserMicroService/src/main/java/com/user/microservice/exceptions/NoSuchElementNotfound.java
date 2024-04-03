package com.user.microservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoSuchElementNotfound extends RuntimeException {
	
	private String errorCode;
	private String errorMessage;

}
