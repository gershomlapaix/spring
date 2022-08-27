package com.lapaix.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
     /*
      * 
  	// @Before advice
	
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
	
	@Before("com.lapaix.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>>> Executing @Before advice on a method");
		
		//  display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("\nMethod: "+ methodSig+"\n\n");
		
		// display method arguments
	}
	
}
