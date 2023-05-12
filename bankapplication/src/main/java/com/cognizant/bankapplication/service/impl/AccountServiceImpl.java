package com.cognizant.bankapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.repository.AccountRepository;
import com.cognizant.bankapplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Long SaveAccountDetails(Account account) {
		accountRepository.save(account);
		return account.getAccountId();
	}

	@Override
	public Account findByAccountId(Long accountId) {
		Account fetchedDetails = accountRepository.findByAccountId(accountId);
		return fetchedDetails;
	}

}
