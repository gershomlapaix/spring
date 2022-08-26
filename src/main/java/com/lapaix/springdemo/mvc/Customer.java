package com.lapaix.springdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	
	@NotNull(message="is required")
	@Size(min=2)
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}

	
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
