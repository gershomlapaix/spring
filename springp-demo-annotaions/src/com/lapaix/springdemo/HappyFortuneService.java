package com.lapaix.springdemo;

import org.springframework.stereotype.Component;

@Component    // spring container will register this bean
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day";
	}

}
