package com.cognizant.bankapplication.service;

import java.math.BigInteger;

import com.cognizant.bankapplication.model.Account;

public interface AccountService {

	public BigInteger SaveAccountDetails(Account account);

	public Account findByAccountId(BigInteger accountId);

	public Account updateAccount(Account account,BigInteger id) ; 
	
	public BigInteger deleteAccountById(BigInteger accountId);
}
