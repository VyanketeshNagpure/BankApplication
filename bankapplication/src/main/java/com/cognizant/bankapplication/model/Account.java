package com.cognizant.bankapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
	
	@Id
	private String accountId;
	private String customerName;
	private String permanentAccountNumber;
	private String dateOfBirth;
	private String acocuntType;
	private String accountStatus;
	private String accountBalance;
	private String phoneNumber;
	private String emailId;
	private String monthlyAverageBalance;

	public Account() {
		super();
	}

	public Account(String accountId, String customerName, String permanentAccountNumber, String dateOfBirth,
			String acocuntType, String accountStatus, String accountBalance, String phoneNumber, String emailId,
			String monthlyAverageBalance) {
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
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

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
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

	public String getMonthlyAverageBalance() {
		return monthlyAverageBalance;
	}

	public void setMonthlyAverageBalance(String monthlyAverageBalance) {
		this.monthlyAverageBalance = monthlyAverageBalance;
	}

	@Override
	public String toString() {
		return "Acount [accountId=" + accountId + ", customerName=" + customerName + ", permanentAccountNumber="
				+ permanentAccountNumber + ", dateOfBirth=" + dateOfBirth + ", acocuntType=" + acocuntType
				+ ", accountStatus=" + accountStatus + ", accountBalance=" + accountBalance + ", phoneNumber="
				+ phoneNumber + ", emailId=" + emailId + ", monthlyAverageBalance=" + monthlyAverageBalance + "]";
	}

}
