package com.cognizant.bankapplication.model;

import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
public class Transaction {

	@Id
	private Long transactionId = Long
			.valueOf(Math.abs(ThreadLocalRandom.current().nextLong(100_000_000, 999_999_999L)));;
	
	@NotNull
	private Long accountId;
	private Date dateTime = new Date(System.currentTimeMillis());
	
	
	private Long receiversAccountID;
	
	public enum TransactionType{
	    credit,
	    debit,
	    transfer
	}

	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	@NotNull
	@DecimalMin("15.0")
	private Double amount;

	public Transaction() {
		super();
	}

	public Transaction(Long transactionId, Long accountId, Date dateTime, Long receiversAccountID,
			TransactionType transactionType, Double amount) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.dateTime = dateTime;
		this.receiversAccountID = receiversAccountID;
		this.transactionType = transactionType;
		this.amount = amount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Long getReceiversAccountID() {
		return receiversAccountID;
	}

	public void setReceiversAccountID(Long receiversAccountID) {
		this.receiversAccountID = receiversAccountID;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountId=" + accountId + ", dateTime=" + dateTime
				+ ", receiversAccountID=" + receiversAccountID + ", transactionType=" + transactionType + ", amount="
				+ amount + "]";
	}

}
