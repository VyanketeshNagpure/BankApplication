package com.cognizant.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.model.response.AccountServiceResponseModel;
import com.cognizant.bankapplication.repository.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/test")
	private String testMethod() {
		return "working";
	}
	
	@PostMapping("/account")
	private ResponseEntity<AccountServiceResponseModel> createAccount(@RequestBody Account account) {
		
		accountRepository.save(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(new AccountServiceResponseModel("created Account Entry"));
	}
	
	@GetMapping("/account/{accountId}")
	private ResponseEntity<Account> getByAccountId(@PathVariable String accountId){
		
		Account record = accountRepository.findByAccountId(accountId);
		System.out.println(record);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(record);
	}

}
