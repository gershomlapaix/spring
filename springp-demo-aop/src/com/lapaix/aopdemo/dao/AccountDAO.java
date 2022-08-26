package com.lapaix.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.lapaix.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean VIP) {
		System.out.println(getClass() + ": DOING THE DB OF ADDING AN ACCOUNT");
	}
}
