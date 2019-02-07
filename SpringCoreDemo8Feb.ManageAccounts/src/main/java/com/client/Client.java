package com.client;

import java.util.Scanner;

import com.java.dto.Account;
import com.java.dto.AccountType;
import com.java.exception.DatabaseException;
import com.java.service.AccountService;
import com.java.service.AccountServiceImpl;

//core java: serialization/ read a file/ cloning/ hashmap 
public class Client {

	static AccountService service= new AccountServiceImpl();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Choose the option:");
			System.out.println("1. Open an account");
			System.out.println("2. Close account");
			System.out.println("3. Update account details");
			System.out.println("4. Get account details");
			System.out.println("5. View all accounts");// security: authenication & authorization
			System.out.println("6. Exit");
			int chosenOption = Integer.parseInt(scanner.nextLine());// nextInt/ nextFloat/nextChar: do not capture ur
																	// enter
			switch (chosenOption) {
			case 1:
				System.out.println("Enter your name");
				String holdername = scanner.nextLine();
				System.out.println("Enter your opening balance");
				float balance = Float.parseFloat(scanner.nextLine());
				System.out.println("Enter the account type (Checking/ Savings)");
				String type = scanner.nextLine();
				Account account = new Account(holdername, balance, AccountType.getType(type));
				try {
					service.createAccount(account);
				} catch (DatabaseException e) {
					System.out.println("Error creating account" + e.getMessage());
				}
				break;
			case 6:
				System.exit(0);
			}
		}
	}

}
