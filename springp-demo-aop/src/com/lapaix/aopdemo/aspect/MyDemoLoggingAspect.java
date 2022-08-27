package com.lapaix.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
     /*
      * 
      * 	// @Before advice
	
//	@Before("execution(public void com.lapaix.aopdemo.dao.AccountDAO.addAccount())")   // gonna do spying
	
//	@Before("execution(public void add*())")
	
//	@Before("execution(void add*())") // with the return type of void
	
//	@Before("execution(* add*())") // match any return type
	
//	@Before("execution(* add*(com.lapaix.aopdemo.Account))") // with the method having account class as a parameter
	
//	@Before("execution(* add*(com.lapaix.aopdemo.Account,..))")
	
//	@Before("execution(* add*(..))")   // zero to many parameters
	@Before("execution(* com.lapaix.aopdemo.dao.*.*(..))") // package with any class and any method in the dao package
	public void beforeAddAccountAdvice() {
		System.out.println("\n========>>> Executing @Before advice on a method");
	}
      */
	
	
	
	/**
	 * 
	 
	// Pointcut declarations
	
	@Pointcut("execution(* com.lapaix.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	
	// use the pointcut declared above
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n========>>> Executing @Before advice on a method");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n========>>> Performing api analytics...");
	}
	 */
	
	
	@Pointcut("execution(* com.lapaix.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.lapaix.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter methods	 
	@Pointcut("execution(* com.lapaix.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	// apply on the package class methods excluding getters and setters
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n========>>> Performing api analytics...");
	}
}
