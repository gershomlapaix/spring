package com.lapaix.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component        // again..., enable component scanning by spring container
public class TrafficFortuneService {
	
	public String getFortune() {
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// return a fortune
		return "expecting heavy traffic";
	}
	
}
