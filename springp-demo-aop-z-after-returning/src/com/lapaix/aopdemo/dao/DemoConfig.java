package com.lapaix.aopdemo.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  // Spring AOP proxy support
@ComponentScan("com.lapaix.aopdemo")
public class DemoConfig {
	
}
