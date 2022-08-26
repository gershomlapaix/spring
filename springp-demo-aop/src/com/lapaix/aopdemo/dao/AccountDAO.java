package com.lapaix.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING THE DB OF ADDING AN ACCOUNT");
	}
}
