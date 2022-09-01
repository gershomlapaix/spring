package com.lapaix.aopdemo.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lapaix.aopdemo.Account;
import com.lapaix.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	
	private static Logger logger = Logger.getLogger(AroundDemoApp.class.getName());
	
	public static void main(String[] args) {
			
		// read spring config java class
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
				
				// get the bean  from spring container
				TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
				
				logger.info("\n Main program: AroundDemoApp");
				
				logger.info("\n Calling getFortune()");
				
				boolean tripWire = true;
				String data = theFortuneService.getFortune(tripWire);
				logger.info("\nThe fortune data : "+ data);
				logger.info("\nfinished");
				// close the context
				context.close();
	}
	
}
