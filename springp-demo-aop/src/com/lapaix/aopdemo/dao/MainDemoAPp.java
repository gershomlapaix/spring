package com.lapaix.aopdemo.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoAPp {
	
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean  from spring container
		AccountDAO theAccountDAO  = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theDao = context.getBean("membershipDAO", MembershipDAO.class);
		SillyDAO theSillyDAO = context.getBean("sillyDAO", SillyDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();
		theDao.addAccount();
		theSillyDAO.addAccount();
		
		// close the context
		context.close();
	}
	
}
