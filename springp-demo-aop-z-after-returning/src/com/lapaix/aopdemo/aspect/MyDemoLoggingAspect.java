package com.lapaix.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.lapaix.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	/** 
	 * @Around: combination of @Before and @After, and also with fine grained stuffs
	 * ProceedingJoinPoint : a handle to the target method
	*/
	@Around("execution(* com.lapaix.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theproJoinPoint)throws Throwable {
		// print the method we are advising on
		// print out which method we are advising on
			String methodSig =  theproJoinPoint.getSignature().toShortString()	;
				System.out.println("\n========>>> Executing @Around on method: "+ methodSig);

		// get begin timestamp
				long begin = System.currentTimeMillis();
		
		// execute the method
				Object result = theproJoinPoint.proceed();
		
		// get the end timestamp
				long end = System.currentTimeMillis();
		
		
		// compute the duration and display it
				long duration  = end - begin;
				System.err.println("\n Duration taken to execute the method : "+duration/1000.0+ " secs");
	
				return result;
	}
	
	// @After implementation:  runs regardless what ( works as finally block)
	@After("execution(* com.lapaix.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();;
		System.out.println("\n========>>> Executing @After (finally) on method: "+ methodSig);

	}
	
	// @AfterThrowing implementation
	@AfterThrowing
	(
		pointcut = "execution(* com.lapaix.aopdemo.dao.AccountDAO.findAccounts(..))",
		throwing="theExc"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		// print out which method we are advising on
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();;
		System.out.println("\n========>>> Executing @AfterThrowing on method: "+ methodSig);

		// log the exception
		System.out.println("\n========>>> The exception is : "+ theExc);
	
	}
	
	@Before("com.lapaix.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>>> Executing @Before advice on a method");
		
		//  display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("\nMethod: "+ methodSig+"\n\n");
		
		// display method arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account){
				// downcast and print Account data
				
				Account theAccount = (Account) tempArg;
				System.out.println("account name: "+theAccount.getName());
			}
		}
	}
	
	@AfterReturning(pointcut = "execution(* com.lapaix.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result)
	{
		
		// print out which method we are advising
		String method = theJoinPoint.getSignature().toString();
		System.out.println("\n========>>> Executing @AfterReturning on method: "+ method);
		
		// print out the results of the method call
		System.out.println("\n========>>> result is: "+result);
		
		// let's post-process the data ...
		
		convertAccountNamesToUppercase(result);
		
		// print out the results of the method call
		System.out.println("\n========>>> result is: "+result);
		
	}

	private void convertAccountNamesToUppercase(List<Account> result) {
		// loop through the accounts
		for(Account tempAccount: result) {		
			// get the uppercase version of the name
			String uppercaseName = tempAccount.getName().toUpperCase();		
			
			// update the name on the account
			tempAccount.setName(uppercaseName);
		}
	
	}	
}
