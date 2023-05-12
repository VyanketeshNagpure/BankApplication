package com.cognizant.bankapplication.model;


import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {

	@Id
	private Long transactionId = Long.valueOf(Math.abs(ThreadLocalRandom.current()
			  .nextLong(1_000_000, 9_999_999L)));;
	private Long AccountId;
	private Date DateTime = new Date(System.currentTimeMillis());
	private Integer Amount;
	private String transactionType;
	private Long ReceiversAccountID;
	

	public Transaction() {
		super();
	}

	public Transaction(Long transactionId, Long accountId, Date dateTime, Integer amount, String transactionType,
			Long receiversAccountID) {
		super();
		this.transactionId = transactionId;
		AccountId = accountId;
		DateTime = dateTime;
		Amount = amount;
		this.transactionType = transactionType;
		ReceiversAccountID = receiversAccountID;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountId() {
		return AccountId;
	}

	public void setAccountId(Long accountId) {
		AccountId = accountId;
	}

	public Date getDateTime() {
		return DateTime;
	}

	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}

	public Integer getAmount() {
		return Amount;
	}

	public void setAmount(Integer amount) {
		Amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getReceiversAccountID() {
		return ReceiversAccountID;
	}

	public void setReceiversAccountID(Long receiversAccountID) {
		ReceiversAccountID = receiversAccountID;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", AccountId=" + AccountId + ", DateTime=" + DateTime
				+ ", Amount=" + Amount + ", transactionType=" + transactionType + ", ReceiversAccountID="
				+ ReceiversAccountID + "]";
	}
	
	
	

}
