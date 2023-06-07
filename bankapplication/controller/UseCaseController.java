package com.cognizant.bankapplication.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.model.Statement;
import com.cognizant.bankapplication.model.Transaction;
import com.cognizant.bankapplication.model.response.AccountServiceResponseModel;
import com.cognizant.bankapplication.repository.AccountRepository;
import com.cognizant.bankapplication.service.EmailService;

@RestController
public class UseCaseController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	EmailService emailService;
	
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
	
	@GetMapping("/positiveBalaceAndpositiveMAB")
	private List<Account> findAllUserWithPositiveBalancewithmonthlyAverageBalance() {
		
		 return accountRepository.findAllUserWithPositiveBalancewithMonthlyAverageBalance();
	}
	
	@GetMapping("/SendInvestmentEmail")
	private ResponseEntity<AccountServiceResponseModel> sendEmail() {
		
		List<Account> allValidUsers = findAllUserWithPositiveBalancewithmonthlyAverageBalance();
		String EmailBody= "Hi,\r\n"
				+ "\r\n"
				+ "You and I spoke a few years back. Now We are starting the funding process for a new company, XYZ bank.\r\n"
				+ "\r\n"
				+ "Briefly, Our Company has a simple solution for companies to manage sales and marketing presentations across the globe and across devices. Our current customers include NBC, HBO, Western Union, Hearst, DirectTV, and Dior. We are self-funded to date.\r\n"
				+ "\r\n"
				+ "Can I send you our pitch deck?\r\n"
				+ "\r\n"
				+ "Thanks,\r\n"
				+ "\r\n"
				+ "[From XYZ BANK]";
				for(Account acc : allValidUsers) {
			
		emailService.sendEmail(acc.getEmailId(),"Investment Mail", EmailBody);
		}
		return ResponseEntity.status(HttpStatus.OK).body(new AccountServiceResponseModel(" Email has been sent successfully."));
	}
	
}
