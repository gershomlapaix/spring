package com.lapaix.aopdemo.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lapaix.aopdemo.Account;

public class MainDemoApp {
	
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean  from spring container
		AccountDAO theAccountDAO  = context.getBean("accountDAO", AccountDAO.class);
		
		// call the method to find the accounts
		List<Account> accounts  = theAccountDAO.findAccounts(false);
		
		// display the accounts
		System.out.println("\n Main program: AfterReturningDemoApp");
		
		System.out.println(accounts);
		System.out.println("------");
		
		// close the context
		context.close();
	}
	
}
