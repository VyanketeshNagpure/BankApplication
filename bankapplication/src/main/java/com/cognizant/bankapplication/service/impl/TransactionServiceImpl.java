package com.cognizant.bankapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		Account requiredAccount = accountRepository.findByAccountId(accountID);
		transactionRepository.save(transaction);

		Double accountBalance = requiredAccount.getAccountBalance();
		if (transaction.getTransactionType().equalsIgnoreCase("credit")) {
			accountBalance = accountBalance + transaction.getAmount();
		} else if (transaction.getTransactionType().equalsIgnoreCase("debit")) {
			accountBalance = accountBalance - transaction.getAmount();
		}

		requiredAccount.setAccountBalance(accountBalance);
		
		Double monthlyAverageBalance = requiredAccount.getMonthlyAverageBalance();
		if( monthlyAverageBalance != null) {
			Long NumberOfTransactions = transactionRepository.countByAccountId(accountID);
		requiredAccount.setMonthlyAverageBalance((monthlyAverageBalance*NumberOfTransactions+transaction.getAmount())/(NumberOfTransactions+1));
		}
		
		accountServiceImpl.updateAccount(requiredAccount, accountID);
		return transaction.getTransactionId();
	}

}
