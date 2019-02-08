package com.java.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//This code would be automatically added at the compile time.
@Getter
@Setter
@ToString
public class Account {

	private int accountNumber;
	private String holderName;
	private float balance;
	private AccountType type;
	
	public Account(String holderName, float balance, AccountType type) {
		this.holderName= holderName;
		this.balance= balance;
		this.type= type;
	}
	
}
