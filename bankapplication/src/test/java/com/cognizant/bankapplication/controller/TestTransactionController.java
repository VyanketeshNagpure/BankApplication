package com.cognizant.bankapplication.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigInteger;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.model.Account.accountType;
import com.cognizant.bankapplication.repository.AccountRepository;
import com.cognizant.bankapplication.service.AccountService;

@SpringBootTest
@AutoConfigureMockMvc
class TestTransactionController {
		@Autowired 
		MockMvc mockMvc;
		@MockBean
		AccountRepository accountRepository;
		@Mock
		Account account;
		@Mock
		AccountService accountService;
		
@Test
void TestCreateTransaction() throws Exception {
	Account account = new Account();
	account.setAccountId(BigInteger.valueOf(1276860007));
	account.setAccountBalance(20000d);
	account.setAccountStatus("open");
	account.setAccountType(accountType.NonSalary);
	account.setCustomerName("sumit");
	account.setDateOfBirth("2001-01-01");
	account.setEmailId("test@gmail.com");
	account.setPhoneNumber("9011426749");
	account.setPermanentAccountNumber("CKQPN0467T");

	when(accountRepository.findById(any()))
		.thenReturn(Optional.of(account));
	mockMvc.perform(post("/transaction").content("{\r\n"
			+ "    \"accountId\": \"1276860066\",\r\n"
			+ "    \"amount\": \"15000\",\r\n"
			+ "    \"transactionType\":\"credit\"\r\n"
			+ "}").contentType(MediaType.APPLICATION_JSON)) 
	.andExpect(status().isCreated());
			   
			   
			   
	}


}
