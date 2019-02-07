package com.java.service;


import java.util.List;

import com.java.dto.Account;
import com.java.exception.DatabaseException;

public interface AccountService {
	public int createAccount(Account account) throws DatabaseException;
	public Account getAccountByNumber(int accountNumber);
	public List<Account> getAccounts();
	public int updateAccount(Account account);
	public boolean deleteAccount(int accountNumber);
}
//AccountService service= new AccountServiceImpl2();