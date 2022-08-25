package com.lapaix.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "hello-world-form";
	}
	
//	a controller method to process form data
	@RequestMapping("/processForm")
	public String processIncomingFormData() {
		return "confirmation  ";
	}
	
//	new controller method to read form data and add data to the model
	@RequestMapping("/processFormV2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String yourNames = request.getParameter("names");
		
		yourNames = yourNames.toUpperCase();
		
		String result ="Yo! " + yourNames;
		
		model.addAttribute("message", result);
		
		return "confirmation";
	}
}
