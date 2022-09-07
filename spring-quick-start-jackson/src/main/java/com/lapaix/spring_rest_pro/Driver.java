package com.lapaix.spring_rest_pro;

import java.io.File;
import java.util.Iterator;

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
			System.out.println("\n");
			System.out.println("First name : "+ theStudent.getFirstName());
			System.out.println("First name : "+ theStudent.getLastName());
			
			Address tempAddress = theStudent.getAddress();
			System.out.println("The street is "+ tempAddress.getStreet() + " in "+ tempAddress.getCountry());
			
			System.out.println("The languages : ");
			for(String lang: theStudent.getLanguages()) {
				System.out.println(lang);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
