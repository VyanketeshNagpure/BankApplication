package com.cognizant.bankapplication.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.bankapplication.model.Account;
import com.cognizant.bankapplication.model.Transaction;

public interface AccountRepository extends JpaRepository<Account, BigInteger>{
	
	public Account findByAccountId(Long accountId); 
	
	@Query(value = "SELECT a FROM Account a WHERE a.accountBalance > 0")
	List<Account> findAllUserWithPositiveBalance();
	
	@Query(value = "SELECT t FROM Transaction t WHERE t.accountId = ?1")
	List<Transaction> findAllTransactionWithPositiveBalance(BigInteger accountId);
	
}
 