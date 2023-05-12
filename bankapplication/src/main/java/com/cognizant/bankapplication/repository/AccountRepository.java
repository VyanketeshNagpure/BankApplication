package com.cognizant.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.bankapplication.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public Account findByAccountId(Long accountId); 
}
