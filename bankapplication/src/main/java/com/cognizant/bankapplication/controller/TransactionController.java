package com.cognizant.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bankapplication.model.Transaction;
import com.cognizant.bankapplication.model.response.AccountServiceResponseModel;
import com.cognizant.bankapplication.service.TransactionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transac/acc")
	private String testMethod() {
		return "working";
	}
	
	@PostMapping("/transaction")
	private ResponseEntity<AccountServiceResponseModel> createTransaction(@RequestBody Transaction transaction){
		
		Long TransactionId = transactionService.createTransaction(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).body(new AccountServiceResponseModel("created Transaction Entry with id :" + TransactionId));
	}
	

}
