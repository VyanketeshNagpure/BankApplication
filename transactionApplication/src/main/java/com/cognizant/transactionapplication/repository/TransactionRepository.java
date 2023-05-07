package com.cognizant.transactionapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.transactionapplication.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{

}
