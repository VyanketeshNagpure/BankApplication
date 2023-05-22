package com.cognizant.bankapplication.model;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@SequenceGenerator(name="account_id_seq", initialValue=1_276_860_001, allocationSize = 0)
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_id_seq")
	private BigInteger accountId;
	
	@NotEmpty
	@Size(min= 3, message="CustomerName should have at least 3 characters")
	private String customerName;
	
	@NotEmpty
	@Pattern(regexp="(^$|[A-Z]{5}[0-9]{4}[A-Z]{1})",message = "First five characters are letters, next 4 numerals, last character letter")
	private String permanentAccountNumber;
	
	@Pattern(regexp = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$",message= "enter in date format yyyy-MM-dd")
	private String dateOfBirth;
	
	@NotEmpty
	@Size(min= 3, message="AcocuntType should have at least 3 characters")
	private String acocuntType;
	
	@NotEmpty
	@Size(min= 3, message="AccountStatus should have at least 3 characters")
	private String accountStatus;
	
	private Double accountBalance;
	
	@NotEmpty
	@Pattern(regexp="(^$|[0-9]{10})", message="PhoneNumber should have 10 digits")
	private String phoneNumber;
	
	@Email
	@Size(min= 3, message="Please Enter Correct Email format.")
	private String emailId;
	
	private Double monthlyAverageBalance;

	public Account() {
		super();
	}

	public Account(BigInteger accountId, String customerName, String permanentAccountNumber, String dateOfBirth,
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

	public BigInteger getAccountId() {
		return accountId;
	}

	public void setAccountId(BigInteger accountId) {
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
