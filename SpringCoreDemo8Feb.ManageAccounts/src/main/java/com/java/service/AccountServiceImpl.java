package com.java.service;

import java.util.List;

import com.java.dao.AccountRepository;
import com.java.dao.AccountRepositoryImpl;
import com.java.dto.Account;
import com.java.exception.DatabaseException;

public class AccountServiceImpl implements AccountService{
	//spring will create the object and do dependency injection
	AccountRepository repository= new AccountRepositoryImpl();

	@Override
	public int createAccount(Account account) throws DatabaseException {
		return repository.createAccount(account);
	}

	@Override
	public Account getAccountByNumber(int accountNumber) {
		return repository.getAccountByNumber(accountNumber);
	}

	@Override
	public List<Account> getAccounts() {
		return repository.getAccounts();
	}

	@Override
	public int updateAccount(Account account) {
		return repository.updateAccount(account);
	}

	@Override
	public boolean deleteAccount(int accountNumber) {
		return repository.deleteAccount(accountNumber);
	}

}
