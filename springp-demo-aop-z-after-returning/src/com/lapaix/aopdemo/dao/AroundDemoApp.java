package com.lapaix.aopdemo.dao;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lapaix.aopdemo.Account;

public class AroundDemoApp {
	
	public static void main(String[] args) {
				
		// read spring config java class
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
				
				// get the bean  from spring container
				AccountDAO theAccountDAO  = context.getBean("accountDAO", AccountDAO.class);
				
				List<Account> theAccounts = null;
				
				try {
					boolean tripWire = true;
					theAccounts = theAccountDAO.findAccounts(tripWire);
				}
				catch (Exception exc) {
					System.out.println("\n\n Main program ... caught exception: "+ exc);
				}
				
				System.out.println("\n\n Main program: AfterThrowingDemoApp");
				System.out.println("-----");
				
				System.out.println(theAccounts);
				System.out.println("\n");
				
				// close the context
				context.close();
	}
	
}
