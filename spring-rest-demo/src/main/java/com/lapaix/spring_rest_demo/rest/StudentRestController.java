package com.lapaix.spring_rest_demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lapaix.spring_rest_demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Student> theStudents;
	
	// define @PostContstruct to load the student data .... only once
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Patrick", "Kareem"));
		theStudents.add(new Student("Nesta", "Mario"));
	}
	
	
	// define the endpoint for "/students"
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	/**
	 *  define the endpoint for "/students/{studentId}"
	 *  @PathVarible binds the incoming request value with the identified parameter
	 * */
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return theStudents.get(studentId);
	}

}
