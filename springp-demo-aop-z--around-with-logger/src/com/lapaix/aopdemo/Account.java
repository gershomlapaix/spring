package com.lapaix.aopdemo;


public class Account {
	
	private String level;
	private String name;
	
	public Account() {}
	
	public Account( String name, String level) {
		this.level = level;
		this.name = name;
	}



	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Account [level=" + level + ", name=" + name + "]";
	}
	
	
	
}
