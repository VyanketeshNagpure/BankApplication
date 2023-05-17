package com.cognizant.bankapplication.service;

import com.cognizant.bankapplication.model.Account;

public interface AccountService {

	public Long SaveAccountDetails(Account account);

	public Account findByAccountId(Long accountId);

	public Account updateAccount(Account account,Long id) ; 
	
	public Long deleteAccountById(Long accountId);
}
