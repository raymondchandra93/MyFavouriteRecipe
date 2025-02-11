package com.raymondchandra.MyFavouriteRecipe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleStudentNotFoundException(UserNotFoundException e) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler
//	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//	}
//
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleGlobalException(Exception e) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("An error occured: " + e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
