package com.lapaix.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// start with @Before advice 
//	@Before("execution(public void addAccount())")   // gonna do spying
	@Before("execution(public void updateAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n========>>> Executing @Before advice on an updateAccount()");
	}
}
