package com.cognizant.bankapplication.model;

import java.math.BigInteger;
import java.util.List;

public class Statement {
	
	BigInteger accountID;
	List<Transaction> statement;
	
	
	public Statement(BigInteger accountID, List<Transaction> statement) {
		super();
		this.accountID = accountID;
		this.statement = statement;
	}
	
	public BigInteger getAccountID() {
		return accountID;
	}
	public void setAccountID(BigInteger accountID) {
		this.accountID = accountID;
	}
	public List<Transaction> getStatement() {
		return statement;
	}
	public void setStatement(List<Transaction> statement) {
		this.statement = statement;
	}
	
	

}
