package com.cognizant.transactionapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	
	@GetMapping("/test")
	private String testMethod() {
		return "working";
	}

}
