package com.lapaix.spring_rest_demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lapaix.spring_rest_demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// define the endpoint for "/students"
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("Patrick", "Kareem"));
		students.add(new Student("Nesta", "Mario"));
		return students;
	}

}
