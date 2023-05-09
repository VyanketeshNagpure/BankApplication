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
import com.cognizant.bankapplication.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	

	@GetMapping("/test")
	
	private String testMethod() {
		return "working :)";
	}

	@PostMapping("/account")
	private ResponseEntity<AccountServiceResponseModel> createAccount(@RequestBody Account account) {

		Long AccountId = accountService.SaveAccountDetails(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(new AccountServiceResponseModel("created Account Entry",AccountId));
	}

	@GetMapping("/account/{accountId}")
	private ResponseEntity<Account> getByAccountId(@PathVariable String accountId) {

		Account record = accountService.findByAccountId(accountId);

		return ResponseEntity.status(HttpStatus.FOUND).body(record);
	}

}
