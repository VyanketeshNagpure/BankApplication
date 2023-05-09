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

	
	@Override
	  public Account update(Account account, Long id) {
		 Account existingCustomer= accountRepository.findByAccountId(id);
				/* orElseThrow(() -> new ResourceNotFoundException("Account","Id",id));*/
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
	public void deleteCustomerById(Long accountId) {
		 accountRepository.findByAccountId(accountId);/*.orElseThrow(
	     ()->new ResourceNotFoundException("Account","accountId",accountId));*/
		accountRepository.deleteById(accountId);
	}
	
	
}
