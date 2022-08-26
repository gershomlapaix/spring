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
	@Before("execution(void add*())") // with the return type of void
	public void beforeAddAccountAdvice() {
		System.out.println("\n========>>> Executing @Before advice on a method");
	}
}
