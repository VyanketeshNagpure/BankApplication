package com.cognizant.bankapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bankapplication.model.Transaction;
import com.cognizant.bankapplication.repository.TransactionRepository;

@Service
public class TransactionServiceImpl  implements com.cognizant.bankapplication.service.TransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	public Long createTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
		return transaction.getTransactionId();
	}
	
}
