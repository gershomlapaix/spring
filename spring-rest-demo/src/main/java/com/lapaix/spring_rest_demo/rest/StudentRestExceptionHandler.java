package com.lapaix.spring_rest_demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // required first
public class StudentRestExceptionHandler {

	/** Adding an exception handler using @ExceptionHandler*/
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException (StudentNotfoundException exc){
		
		// create a StudentErrorResponse
		StudentErrorResponse error =  new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return the responseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	

	/** Adding another exception handler */
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		StudentErrorResponse error =  new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return the responseEntity
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
