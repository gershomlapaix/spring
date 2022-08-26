package com.lapaix.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
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

//      Binding the request parameters with the method parameters
		@RequestMapping("/processFormV3")
		public String processFormVersion3(@RequestParam("names") String name, Model model) {
			
			name = name.toUpperCase();
			
			String result ="Hey my! " + name;
			
			model.addAttribute("message", result);
			
			return "confirmation";
		}
}
