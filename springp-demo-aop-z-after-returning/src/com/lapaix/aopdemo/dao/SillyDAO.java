package com.lapaix.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class SillyDAO {
	
	public boolean addAccount() {
		System.out.println(getClass()+" Adding silly account");
		
		return true;
	}
}
