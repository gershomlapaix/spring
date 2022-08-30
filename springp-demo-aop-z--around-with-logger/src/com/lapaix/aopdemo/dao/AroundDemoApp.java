package com.lapaix.aopdemo.dao;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lapaix.aopdemo.Account;
import com.lapaix.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	
	public static void main(String[] args) {
				
		// read spring config java class
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
				
				// get the bean  from spring container
				TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
				
				System.out.println("\n Main program: AroundDemoApp");
				
				System.out.println("\n Calling getFortune()");
				
				String data = theFortuneService.getFortune();
				System.out.println("\nThe fortune data : "+ data);
				System.out.println("\nfinished");
				// close the context
				context.close();
	}
	
}
