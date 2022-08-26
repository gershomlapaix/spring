package com.lapaix.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemo {

		public static void main(String[] args) {
			
//			read spring config java file
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
			
//			get the bean from spring container
			SwimCoach theCoach =  context.getBean("swimCoach", SwimCoach.class);
			
//			call a method on the bean
			System.out.println(theCoach.getDailyWorkout());
			
			System.out.println(theCoach.getDailyFortune());
			
//			call methods on swim coach
			System.out.println("email:: "+theCoach.getEmail());
			System.out.println("team:: "+theCoach.getTeam());

			
//			close context
			context.close();

		}

	}