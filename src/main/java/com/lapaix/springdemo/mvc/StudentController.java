package com.lapaix.springdemo.mvc;

/*
 * @Author: Gershom
 * @Lesson: Spring MVC form tags
 * 
 * This is a controller containing methods that deal with forms and their data
 * 
 * */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// create student object
		Student theStudent = new Student();
		
		// add student object to the model
		model.addAttribute("student", theStudent);
		
		return "student-form";
	}
}
