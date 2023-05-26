package com.cognizant.bankapplication.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
public class TestAccountController {
	
	@Autowired 
	MockMvc mockMvc;
	
	@MockBean
	AccountRepository accountRepository;
	@Mock
	Account account;
	@Mock
	AccountService accountService;
	
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
	void testCreateAccountWithBadInput() throws Exception {
		
		mockMvc.perform(post("/account").content("{\r\n"
				+ "    \"customerName\": \"su\",\r\n"
				+ "    \"permanentAccountNumber\": \"ABDF1234R\",\r\n"
				+ "    \"dateOfBirth\":\"2001-01-01\",\r\n"
				+ "    \"AccountType\":\"savings\",\r\n"
				+ "    \"accountStatus\":\"open\",\r\n"
				+ "    \"accountBalance\":\"20000\",\r\n"
				+ "    \"phoneNumber\":\"9011592901\",\r\n"
				+ "    \"emailId\":\"prashantdhainje1998@gmail.com\"\r\n"
				+ "}").contentType(MediaType.APPLICATION_JSON))
			   .andExpect(status().isBadRequest());
	}
	
	@Test
	void testGetAccount() throws Exception {
		
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
		mockMvc.perform(get("/account/"+BigInteger.valueOf(127686))).andExpect(status().isFound());
	}
	
	
	@Test
    void deleteAccountById() throws Exception {
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
	
        mockMvc.perform(delete("/account/"+BigInteger.valueOf(127686)))
                .andExpect(status().isFound());
    }
	
	
	
	 @Test
	    void updateAccount() throws Exception {
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
		
			Account newAccount = new Account();
			newAccount.setAccountId(account.getAccountId());
			newAccount.setCustomerName("Akshay");

	        when(accountRepository.save(any(Account.class))).thenReturn(newAccount);

	        mockMvc.perform(put("/account/"+BigInteger.valueOf(1276860044))
	                .content("{\r\n"
	        				+ "    \"customerName\": \"sumit\",\r\n"
	        				+ "    \"permanentAccountNumber\": \"ABCDF1234R\",\r\n"
	        				+ "    \"dateOfBirth\":\"2001-01-01\",\r\n"
	        				+ "    \"AccountType\":\"savings\",\r\n"
	        				+ "    \"accountStatus\":\"open\",\r\n"
	        				+ "    \"accountBalance\":\"20000\",\r\n"
	        				+ "    \"phoneNumber\":\"9011592901\",\r\n"
	        				+ "    \"emailId\":\"prashantdhainje1998@gmail.com\"\r\n"
	        				+ "}")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isFound());
	    }
	
	
	
	
	
	
	
	
	

}
