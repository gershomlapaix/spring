package com.lapaix.spring_rest_demo.entity;

public class Student {
	
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
		
	public Student() {}
	
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}



	// getters and setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
