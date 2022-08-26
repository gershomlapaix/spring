package com.lapaix.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {
			"The journey is the reward",
			"Diligence is the mother of good luck",
			"Beware of the wolf in sheep's clothing"
	};
	
    // create random number generator
	private Random myRandom = new Random();
	
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		return data[index];
	}

}
