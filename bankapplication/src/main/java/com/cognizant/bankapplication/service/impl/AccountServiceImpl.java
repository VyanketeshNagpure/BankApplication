package com.cognizant.bankapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bankapplication.Exception.ResourceNotFoundException;
import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.repository.AccountRepository;
import com.cognizant.bankapplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Long SaveAccountDetails(Account account) {
		
		if(account.getMonthlyAverageBalance()==null) {
			account.setMonthlyAverageBalance(account.getAccountBalance());
		}
		accountRepository.save(account);
		return account.getAccountId();
	}

	@Override
	public Account findByAccountId(Long accountId) {
		return this.accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account", accountId, "accountId"));

	}

	@Override
	public Account updateAccount(Account account, Long accountId) {
		Account existingCustomer = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account", accountId, "accountId"));
		existingCustomer.setCustomerName(account.getCustomerName());
		existingCustomer.setPermanentAccountNumber(account.getPermanentAccountNumber());
		existingCustomer.setDateOfBirth(account.getDateOfBirth());
		existingCustomer.setAcocuntType(account.getAcocuntType());
		existingCustomer.setAccountStatus(account.getAccountStatus());
		existingCustomer.setAccountBalance(account.getAccountBalance());
		existingCustomer.setPhoneNumber(account.getPhoneNumber());
		existingCustomer.setEmailId(account.getEmailId());
		existingCustomer.setMonthlyAverageBalance(account.getMonthlyAverageBalance());
		accountRepository.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public Long deleteAccountById(Long accountId) {
		accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account", accountId, "accountId"));
		accountRepository.deleteById(accountId);
		
		return accountId;

	}

}
