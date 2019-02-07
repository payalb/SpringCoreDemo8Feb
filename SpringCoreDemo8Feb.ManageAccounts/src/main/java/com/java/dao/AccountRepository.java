package com.java.dao;

import java.util.List;

import com.java.dto.Account;
import com.java.exception.DatabaseException;

//database layer: CRUD: create, read, update, delete
public interface AccountRepository {
//Return the new account number
	public int createAccount(Account account)throws DatabaseException;
	public Account getAccountByNumber(int accountNumber);
	public List<Account> getAccounts();
	//the number of rows updated
	public int updateAccount(Account account);
	public boolean deleteAccount(int accountNumber);
}
