package com.cognizant.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bankapplication.model.Transaction;
import com.cognizant.bankapplication.model.response.AccountServiceResponseModel;
import com.cognizant.bankapplication.service.TransactionService;

import jakarta.validation.Valid;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	
	@GetMapping("/test/transaction")
	private String testTrabsaction() {
		return "Working";
	}
	
	
	@PostMapping("/transaction")
	private ResponseEntity<AccountServiceResponseModel> createNewTransaction(@Valid @RequestBody Transaction transaction){
		
		Long TransctionId = transactionService.createTransaction(transaction);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new AccountServiceResponseModel("transaction successful id : " + TransctionId));
	}
	
	

}
