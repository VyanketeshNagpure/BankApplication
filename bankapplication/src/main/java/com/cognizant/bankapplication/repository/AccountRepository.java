package com.cognizant.bankapplication.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.bankapplication.model.Account;

public interface AccountRepository extends JpaRepository<Account, BigInteger>{
	
	public Account findByAccountId(Long accountId); 
}
