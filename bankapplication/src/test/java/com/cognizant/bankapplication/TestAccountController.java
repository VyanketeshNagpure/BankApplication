package com.cognizant.bankapplication.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.model.Account.accountType;
import com.cognizant.bankapplication.repository.AccountRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class TestAccountController {
	
	@Autowired 
	MockMvc mockMvc;
	
	@MockBean
	AccountRepository accountRepository;
	
	@Test
	void testCreateAccount() throws Exception {
		
		mockMvc.perform(post("/account").content("{\r\n"
				+ "    \"customerName\": \"sumit\",\r\n"
				+ "    \"permanentAccountNumber\": \"ABCDF1234R\",\r\n"
				+ "    \"dateOfBirth\":\"2001-01-01\",\r\n"
				+ "    \"AccountType\":\"savings\",\r\n"
				+ "    \"accountStatus\":\"open\",\r\n"
				+ "    \"accountBalance\":\"20000\",\r\n"
				+ "    \"phoneNumber\":\"9011592901\",\r\n"
				+ "    \"emailId\":\"prashantdhainje1998@gmail.com\"\r\n"
				+ "}").contentType(MediaType.APPLICATION_JSON))
			   .andExpect(status().isCreated());
	}
	
	@Test
	void testGetAccount() throws Exception {
		
		Account account = new Account();
		account.setAccountId(BigInteger.valueOf(12768609));
		account.setAccountBalance(20000d);
		account.setAccountStatus("open");
		account.setAccountType(accountType.NonSalary);
		account.setCustomerName("sumit");
		account.setDateOfBirth("2001-01-01");
		account.setEmailId("test@gmail.com");
		account.setPhoneNumber("9011426749");
		account.setPermanentAccountNumber("CKQPN0467T");
		
		when(accountRepository.findByAccountId(anyLong())).thenReturn(account);
		
		mockMvc.perform(get("/account/"+BigInteger.valueOf(12768609))).andExpect(status().isNotFound());
	}

}
