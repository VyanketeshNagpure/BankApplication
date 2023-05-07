package com.cognizant.bankapplication.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
	
	@Id
	private Long accountId;
	private String customerName;
	private String permanentAccountNumber;
	private Date dateOfBirth;
	private String acocuntType;
	private String accountStatus;
	private Double accountBalance;
	private String phoneNumber;
	private String emailId;
	private Double monthlyAverageBalance;

	public Account() {
		super();
	}

	public Account(Long accountId, String customerName, String permanentAccountNumber, Date dateOfBirth,
			String acocuntType, String accountStatus, Double accountBalance, String phoneNumber, String emailId,
			Double monthlyAverageBalance) {
		super();
		this.accountId = accountId;
		this.customerName = customerName;
		this.permanentAccountNumber = permanentAccountNumber;
		this.dateOfBirth = dateOfBirth;
		this.acocuntType = acocuntType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.monthlyAverageBalance = monthlyAverageBalance;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPermanentAccountNumber() {
		return permanentAccountNumber;
	}

	public void setPermanentAccountNumber(String permanentAccountNumber) {
		this.permanentAccountNumber = permanentAccountNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAcocuntType() {
		return acocuntType;
	}

	public void setAcocuntType(String acocuntType) {
		this.acocuntType = acocuntType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Double getMonthlyAverageBalance() {
		return monthlyAverageBalance;
	}

	public void setMonthlyAverageBalance(Double monthlyAverageBalance) {
		this.monthlyAverageBalance = monthlyAverageBalance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customerName=" + customerName + ", permanentAccountNumber="
				+ permanentAccountNumber + ", dateOfBirth=" + dateOfBirth + ", acocuntType=" + acocuntType
				+ ", accountStatus=" + accountStatus + ", accountBalance=" + accountBalance + ", phoneNumber="
				+ phoneNumber + ", emailId=" + emailId + ", monthlyAverageBalance=" + monthlyAverageBalance + "]";
	}

	

}
