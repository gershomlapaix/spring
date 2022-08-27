package com.lapaix.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lapaix.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	// method: findAccounts()
	public List<Account> findAccounts(){
		 
		List<Account> myAccounts = new ArrayList<Account>();
		
		Account temp1 = new Account("John", "SIlver");
		Account temp2 = new Account("Patrick", "Platinum");
		Account temp3 = new Account("Nesta", "GOld");

		
		return myAccounts;
	}
	
	// method: addAccount()
	public void addAccount(Account account, boolean VIP) {
		System.out.println(getClass() + ": DOING THE DB OF ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+ "doWork()");
		return true;
	}

	
	public String getName() {
		System.out.println(getClass()+ " in getName()");
		return name;
	}

	
	public void setName(String name) {
		System.out.println(getClass()+ "setName()");
		this.name = name;
	}

	
	public String getServiceCode() {
		System.out.println(getClass()+ " in getName()");
		return serviceCode;
	}

	
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ "setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
}
