package com.lapaix.aopdemo.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lapaix.aopdemo.Account;

public class AfterThrowingDemoApp {
	
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean  from spring container
		AccountDAO theAccountDAO  = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theDao = context.getBean("membershipDAO", MembershipDAO.class);
		SillyDAO theSillyDAO = context.getBean("sillyDAO", SillyDAO.class);
		
		// call the business method
		Account myAccount = new Account();
		
		myAccount.setLevel("Platinum");
		myAccount.setName("La paix");
		theAccountDAO.addAccount(myAccount , true);
		theDao.addAccount();
		theSillyDAO.addAccount();
		
		//  call getter and setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();
		
		
		// close the context
		context.close();
	}
	
}
