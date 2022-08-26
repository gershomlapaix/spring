package com.lapaix.springdemo.mvc;

/*
 * @Author: Gershom
 * @Lesson: Spring-mvc validation(using various annotations and hibernate validator)
 * 
 * */

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// show the form
	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		model.addAttribute("customer",new Customer());
		
		return "customer-form";
	}
	
    /*
     * add an initbinder to presprocess the incoming form data
     * remove leading and trailing whitespace
     * resolve issue for our validation
     * 
     * true: means, return null for white space
     * */	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	// the form processing method
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
		
		System.out.println(theBindingResult);
		if(theBindingResult.hasErrors())
		{
		 // if there are some errors, return em to the form
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
		
	}
}
