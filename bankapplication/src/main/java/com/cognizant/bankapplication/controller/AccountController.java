
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

import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.model.response.AccountServiceResponseModel;
import com.cognizant.bankapplication.service.AccountService;
import com.cognizant.bankapplication.service.TransactionService;

import jakarta.validation.Valid;

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
	private ResponseEntity<AccountServiceResponseModel> createAccount(@Valid @RequestBody Account account) {

		Long AccountId = accountService.SaveAccountDetails(account);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new AccountServiceResponseModel("created Account Entry with Acoount NO: " + AccountId));
	}

	@GetMapping("/account/{accountId}")
	private ResponseEntity<Account> findById(@PathVariable Long accountId) {
		Account account = accountService.findByAccountId(accountId);
		return new ResponseEntity<Account>(account, HttpStatus.FOUND);
	}

	@PutMapping("/account/{id}")

	public ResponseEntity<AccountServiceResponseModel> updateAccountByID(@Valid @RequestBody Account account,
			@PathVariable("id") Long id) {

		accountService.updateAccount(account, id);
		return ResponseEntity.status(HttpStatus.FOUND).body(new AccountServiceResponseModel("Update is done"));

	}

	@DeleteMapping("/account/{accountId}")
	public ResponseEntity<AccountServiceResponseModel> deleteAccountById(@PathVariable("accountId") Long accountId) {

		Long deletedAccountId = accountService.deleteAccountById(accountId);
		return  ResponseEntity.status(HttpStatus.FOUND)
				.body(new AccountServiceResponseModel("Account Deleted with id: " + deletedAccountId));

	}
}
