package com.lapaix.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration   // this is Java configuration
//@ComponentScan("com.lapaix.springdemo")   // for scanning classes in the specified package
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
//	define bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();	
	}
	
//	define a bean for swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
