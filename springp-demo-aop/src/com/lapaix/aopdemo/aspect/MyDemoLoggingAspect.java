package com.lapaix.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// start with @Before advice 
//	@Before("execution(public void com.lapaix.aopdemo.dao.AccountDAO.addAccount())")   // gonna do spying
	
//	@Before("execution(public void add*())")
	
//	@Before("execution(void add*())") // with the return type of void
	
//	@Before("execution(* add*())") // match any return type
	
//	@Before("execution(* add*(com.lapaix.aopdemo.Account))") // with the method having account class as a parameter
	
//	@Before("execution(* add*(com.lapaix.aopdemo.Account,..))")
	
	@Before("execution(* add*(..))")   // zero to many parameters
	public void beforeAddAccountAdvice() {
		System.out.println("\n========>>> Executing @Before advice on a method");
	}
}
