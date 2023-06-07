package com.cognizant.bankapplication.service.impl;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(TransactionService.class);

	@Override
	public Long createTransaction(Transaction transaction) {

		BigInteger accountID = transaction.getAccountId();
		Account requiredAccount = accountRepository.findById(accountID)
				.orElseThrow(() -> new ResourceNotFoundException("Account", accountID, "accountId"));
		
		transactionRepository.save(transaction);

		Double accountBalance = requiredAccount.getAccountBalance();
		if (transaction.getTransactionType().toString().equals("credit")) {
			accountBalance = accountBalance + transaction.getAmount();
			logger.trace("Account with id " + accountID + " credited with ammount " + transaction.getAmount());
		} else if (transaction.getTransactionType().toString().equals("debit")) {
			accountBalance = accountBalance - transaction.getAmount();
			logger.trace("Account with id " + accountID + " debited with ammount " + transaction.getAmount());

		} else if (transaction.getTransactionType().toString().equals("transfer")) {
			
			Account requiredRecieversaccountAccount = accountRepository.findById(transaction.getReceiversAccountID())
					.orElseThrow(() -> new ResourceNotFoundException("Account", accountID, "accountId"));
			Double recieversAccountbalanceDouble = requiredRecieversaccountAccount.getAccountBalance();
			
			
			accountBalance = accountBalance - transaction.getAmount();
			recieversAccountbalanceDouble = recieversAccountbalanceDouble + transaction.getAmount();
			requiredRecieversaccountAccount.setAccountBalance(recieversAccountbalanceDouble);
			
			accountServiceImpl.updateAccount(requiredRecieversaccountAccount,
					requiredRecieversaccountAccount.getAccountId());
			
			logger.trace("Account with id " + accountID + " debited with ammount " + transaction.getAmount()
					+ " credited to account " + requiredRecieversaccountAccount.getAccountId());

		}
		requiredAccount.setAccountBalance(accountBalance);

		Double monthlyAverageBalance = requiredAccount.getMonthlyAverageBalance();
		if (monthlyAverageBalance != null) {
			Long NumberOfTransactions = transactionRepository.countByAccountId(accountID);
			requiredAccount
					.setMonthlyAverageBalance((monthlyAverageBalance * NumberOfTransactions + transaction.getAmount())
							/ (NumberOfTransactions + 1));
		}
		
		accountServiceImpl.updateAccount(requiredAccount, accountID);
		
		return transaction.getTransactionId();
	}

}
