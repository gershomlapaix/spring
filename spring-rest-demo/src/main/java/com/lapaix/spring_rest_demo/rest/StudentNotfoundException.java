package com.lapaix.spring_rest_demo.rest;

public class StudentNotfoundException extends RuntimeException{

	public StudentNotfoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotfoundException(String message) {
		super(message);
	}

	public StudentNotfoundException(Throwable cause) {
		super(cause);

	}
	
	
}
