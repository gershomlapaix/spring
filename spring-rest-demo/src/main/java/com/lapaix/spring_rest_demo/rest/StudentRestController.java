package com.lapaix.spring_rest_demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		
		/** check the studentId against the list size */ 
		
		if((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotfoundException("Student id not found - "+studentId);
		}
		
		// if there's happy path
		return theStudents.get(studentId);
	}
	
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
