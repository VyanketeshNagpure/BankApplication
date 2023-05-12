package com.cognizant.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.bankapplication.model.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
