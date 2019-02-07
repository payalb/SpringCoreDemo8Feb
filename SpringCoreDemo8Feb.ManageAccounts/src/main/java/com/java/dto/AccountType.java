package com.java.dto;

public enum AccountType {
	SAVINGS, CHECKING;

	public static AccountType getType(String type) {
		switch (type) {
		case "savings":
		case "Savings":
		case "SAVINGS":
			return AccountType.SAVINGS;
		case "Checking":
		case "checking":
		case "CHECKING":
			return AccountType.CHECKING;
		default:
			return null;
		}
	}
}
