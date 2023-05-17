package com.cognizant.bankapplication.model;

import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Account {

	@Id
	//@Size(min= 10, message="AccountId should have at least 10 digits")
	private Long accountId = Long.valueOf(Math.abs(ThreadLocalRandom.current().nextLong(1_000_000_000, 9_999_999_999L)));
	
	@NotEmpty
	@Size(min= 3, message="CustomerName should have at least 3 characters")
	private String customerName;
	@NotEmpty
	@Size(min= 10,max= 10, message="PermanentAccountNumber should have 10 Digits")
	//@Size(max= 10, message="permanentAccountNumber should have at least 3 characters")
	private String permanentAccountNumber;
	//@NotEmpty
	//@Size(min= 3, message="dateOfBirth should have at least 3 characters")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(pattern = "yyyy-MM-dd", message=" Enter date in yyyy-MM-dd format")
	private Date dateOfBirth;
	@NotEmpty
	@Size(min= 3, message="AcocuntType should have at least 3 characters")
	private String acocuntType;
	@NotEmpty
	@Size(min= 3, message="AccountStatus should have at least 3 characters")
	private String accountStatus;
	//@NotEmpty
	//@Size(min= 3, message="accountBalance should have at least 3 characters")
	private Double accountBalance;
	@NotEmpty
	@Pattern(regexp="(^$|[0-9]{10})", message="PhoneNumber should have 10 digits")
	//@Size(max = 10, message="PhoneNumber should have at least 10 digits")
	//@Size(min = 10, message="PhoneNumber should have at least 10 digits")
	private String phoneNumber;
	@Email
	@Size(min= 3, message="Plaese Enter Correct Email format.")
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
