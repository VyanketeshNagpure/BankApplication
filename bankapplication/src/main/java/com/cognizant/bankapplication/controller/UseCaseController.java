package com.cognizant.bankapplication.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.model.Statement;
import com.cognizant.bankapplication.model.Transaction;
import com.cognizant.bankapplication.repository.AccountRepository;

@RestController
public class UseCaseController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/positiveBalace")
	private List<Account> getAllAccountWithPositiveBalance() {
		
	 return accountRepository.findAllUserWithPositiveBalance();
		
	}
	
	@GetMapping("/positiveBalace/statement")
	private List<Statement> getAllStatementWithPositiveBalance(){
		
		List<Account> allAccountWithPositiveBalance = getAllAccountWithPositiveBalance();
		
		List<BigInteger> listAccountId = new ArrayList<>();
		
		allAccountWithPositiveBalance.stream()
		.forEach(account->listAccountId.add(account.getAccountId()));
		
		
		List<Statement> allAccountStatement = new ArrayList<>();
				
		for(BigInteger accountId : listAccountId){
			List<Transaction> statement = accountRepository.findAllTransactionWithPositiveBalance(accountId);
			allAccountStatement.add(new Statement(accountId, statement));
		}
			
		return allAccountStatement;
		
	}
}
