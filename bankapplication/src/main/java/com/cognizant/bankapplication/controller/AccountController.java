package com.cognizant.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bankapplication.Exception.ResourceNotFoundException;
import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.model.response.AccountServiceResponseModel;
import com.cognizant.bankapplication.service.AccountService;
import com.cognizant.bankapplication.service.TransactionService;


@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	TransactionService transactionService;

	@GetMapping("/acc/test")

	private String testMethod() {
		return "working :)";
	}

	@PostMapping("/account")
	private ResponseEntity<AccountServiceResponseModel> createAccount(@RequestBody Account account) {

		Long AccountId = accountService.SaveAccountDetails(account);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new AccountServiceResponseModel("created Account Entry with Acoount NO:" + AccountId));
	}

	/*@GetMapping("/account/{accountId}")
	private ResponseEntity<Account> getByAccountId(@PathVariable Long accountId) {

		Account record = accountService.findByAccountId(accountId);
		return ResponseEntity.status(HttpStatus.FOUND).body(record);
	}
	/*
	 @GetMapping("{id}")
	public TravelAgency findpassengerById(@PathVariable("id")long id) {
		return travelService.getPassengerById(id);
	}
	
*/
	@GetMapping("/account/{accountId}")
    private ResponseEntity findById(@PathVariable Long accountId) {	  
		try {
			Account account = accountService.findByAccountId(accountId);
			return  new ResponseEntity<Account>(account, HttpStatus.FOUND);
}
		catch(ResourceNotFoundException E) {
			return new ResponseEntity<String>("Invalid Account ID, Please enter "
					+ "valid Account ID. ", HttpStatus.NOT_FOUND);
		}
}
	
	
	
	@PutMapping("/account/{id}")
	
	public ResponseEntity<String> updateAccountByID(@RequestBody Account account, @PathVariable("id") Long id) {
		try{
			accountService.updateAccount(account, id);
			return new ResponseEntity<String>("Update is done.",HttpStatus.FOUND);
		}
		catch(ResourceNotFoundException E)
		{return new ResponseEntity<String>("Invalid Account ID, Please enter "
				+ "valid Account ID.",HttpStatus.NOT_FOUND);
			
		}
}

	@DeleteMapping("/account/{accountId}")
	public ResponseEntity<String> deleteAccountById(@PathVariable("accountId") Long accountId) {
		try {
			Account account= accountService.deleteAccountById(accountId);
		return new ResponseEntity<String>("Account Deleted ",HttpStatus.FOUND);
		
	}
		catch(ResourceNotFoundException E) {
			return new ResponseEntity<String>("Invalid Account ID, Please enter "
					+ "valid Account ID. ",HttpStatus.NOT_FOUND);
		}
	}
}

	
