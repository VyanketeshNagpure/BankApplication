package com.cognizant.bankapplication.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.bankapplication.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	public Long countByAccountId(BigInteger accountId);

}
