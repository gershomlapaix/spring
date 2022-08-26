package com.lapaix.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	
	@NotNull(message="is required")
	@Size(min=2,message="is required")
	private String firstName;
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=10, message="must be lest than or equal to 10")
	private Integer freePasses;
	
	@Pattern(regexp="^[ax-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postalCode;
	
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


	
	public Integer getFreePasses() {
		return freePasses;
	}


	
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}


	
	public String getPostalCode() {
		return postalCode;
	}


	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


}
