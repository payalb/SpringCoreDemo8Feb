package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.java.dao.util.DBUtil;
import com.java.dto.Account;
import com.java.dto.AccountType;
import com.java.exception.DatabaseException;

public class AccountRepositoryImpl implements AccountRepository {

	@Override
	public int createAccount(Account account) throws DatabaseException {
		Connection c;
		try {
			c = DBUtil.getConnection();

			// Performance: compiled, optimized for performance (index)
			// Type safety
			// Prevent sql injection: data is coming from a form: input test field:
			// number: select * from account where accountNumber= ?: 1 or 1 == 1: 1; drop
			// table accounts
			PreparedStatement st = c.prepareStatement("Insert into account values (?,?,?,?)");
			st.setInt(1, 1001);
			st.setString(1, "Payal");
			st.setFloat(2, 23767464.4f);
			st.setObject(3, AccountType.SAVINGS);
			st.executeUpdate();
			/* select account_seq.curval from temp; */

			c.commit();
			c.close();// 1 connection left open to db (200 connections)
		} catch (SQLException e) {
			throw new DatabaseException("Could not create the account" + e.getMessage());
		}
		return 1001;
	}

	@Override
	public Account getAccountByNumber(int accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return false;
	}

}
