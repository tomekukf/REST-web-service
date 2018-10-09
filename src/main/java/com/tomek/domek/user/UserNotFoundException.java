package com.tomek.domek.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//we can comment(below) it and let CustomizedResponseEntityExceptionHandler take full control. if we want to use our method we can uncomment it and provide our implementation with spring boot 
//@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
	}
	

}
