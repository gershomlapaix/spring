package com.lapaix.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)  // will run fast
public class CloudLogAsyncAspect {
	
	@Before("com.lapaix.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("\n========>>> Logging to the cloud async fashion...");
	}
}
