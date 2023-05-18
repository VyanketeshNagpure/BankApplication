package com.cognizant.bankapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bankapplication.Exception.ResourceNotFoundException;
import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.model.Transaction;
import com.cognizant.bankapplication.repository.AccountRepository;
import com.cognizant.bankapplication.repository.TransactionRepository;
import com.cognizant.bankapplication.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountServiceImpl accountServiceImpl;

	@Override
	public Long createTransaction(Transaction transaction) {
		
		Long accountID = transaction.getAccountId();
		Account requiredAccount = accountRepository.findById(accountID)
				.orElseThrow(() -> new ResourceNotFoundException("Account", accountID, "accountId"));
		Account requiredRecieversaccountAccount = accountRepository.findByAccountId(transaction.getReceiversAccountID());
		Double recieversAccountbalanceDouble = requiredRecieversaccountAccount.getAccountBalance();
		transactionRepository.save(transaction);

		Double accountBalance = requiredAccount.getAccountBalance();
		if (transaction.getTransactionType().toString().equals("credit")) {
			accountBalance = accountBalance + transaction.getAmount();
		} else if (transaction.getTransactionType().toString().equals("debit")) {
			accountBalance = accountBalance - transaction.getAmount();
		
		}
		else if (transaction.getTransactionType().toString().equals("transfer")) {
			accountBalance = accountBalance - transaction.getAmount();
		recieversAccountbalanceDouble=recieversAccountbalanceDouble+transaction.getAmount();	
			
		}
		requiredRecieversaccountAccount.setAccountBalance(recieversAccountbalanceDouble);
		requiredAccount.setAccountBalance(accountBalance);
		
		Double monthlyAverageBalance = requiredAccount.getMonthlyAverageBalance();
		if( monthlyAverageBalance != null) {
			Long NumberOfTransactions = transactionRepository.countByAccountId(accountID);
		requiredAccount.setMonthlyAverageBalance((monthlyAverageBalance*NumberOfTransactions+transaction.getAmount())/(NumberOfTransactions+1));
		}
		accountServiceImpl.updateAccount(requiredRecieversaccountAccount, requiredRecieversaccountAccount.getAccountId());
		accountServiceImpl.updateAccount(requiredAccount, accountID);
		System.out.println(requiredRecieversaccountAccount);
		return transaction.getTransactionId();
	}

}
