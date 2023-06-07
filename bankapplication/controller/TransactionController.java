package com.cognizant.bankapplication.controller;

import java.math.BigInteger;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.model.Statement;
import com.cognizant.bankapplication.model.Transaction;
import com.cognizant.bankapplication.model.response.AccountServiceResponseModel;
import com.cognizant.bankapplication.repository.AccountRepository;
import com.cognizant.bankapplication.service.AccountService;
import com.cognizant.bankapplication.service.TransactionService;

import jakarta.validation.Valid;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	@Autowired
	AccountService accountService;
	@Autowired
	AccountRepository accountRepository;
	
	

	@GetMapping("/MonthlyAvgBal/{AccountId}")
	private ResponseEntity<AccountServiceResponseModel> GetMonthlyAvgBal(@PathVariable BigInteger AccountId) {
		Account requiredAccount = accountService.findByAccountId(AccountId);
		System.out.println(requiredAccount);
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new AccountServiceResponseModel("Monthly average balance is : " +requiredAccount.getMonthlyAverageBalance()));
	}
	

	@GetMapping("/Statement/{accountId}")
	private ResponseEntity<Statement> GetStatement(@PathVariable BigInteger accountId) {
		List<Transaction> Statement = accountRepository.findAllTransactionWithPositiveBalance(accountId);
		//logger.trace("Account details fetched with id "+ accountId);
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new Statement(accountId,Statement));
	}

	
	@PostMapping("/transaction")
	private ResponseEntity<AccountServiceResponseModel> createNewTransaction(@Valid @RequestBody Transaction transaction){
		
		Long TransctionId = transactionService.createTransaction(transaction);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new AccountServiceResponseModel("transaction successful id : " + TransctionId));
	}
	
	

}
