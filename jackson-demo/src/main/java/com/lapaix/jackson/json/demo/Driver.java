package com.lapaix.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			
			// create the object mapper
			
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to JAVA POJO
			Student theStudent = mapper.readValue(
					new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("First name : "+ theStudent.getFirstName());
			System.out.println("First name : "+ theStudent.getLastName());
			
			Address tempAddress = theStudent.getAddress();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
