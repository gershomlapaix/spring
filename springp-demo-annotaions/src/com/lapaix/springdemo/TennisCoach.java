package com.lapaix.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired         // (reflection) directly to the field
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//	define a default constructor
	public TennisCoach() {}
	
	/*
	 //	define the init method
	@PostConstruct
	public void doMyInitStuffs() {
		System.out.println("inside doMyStuffs() method ");
	}
	
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("Inside doMyCleanUpStuff() method");
	}
	 */
	
	
	/*
	//	define a setter method
	@Autowired      // for achieving dependency injection
	public void setForturneService(FortuneService fortuneService) {
		System.out.println("Inside setForturneService() method - TennisCoach");
		this.fortuneService = fortuneService;
	}
	 */
	
	/*	
	//	constructor injection
		@Autowired
		public TennisCoach(FortuneService fortuneService) {
			this.fortuneService = fortuneService;
		}
		
    */

	@Override
	public String getDailyWorkout() {
		return "practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
