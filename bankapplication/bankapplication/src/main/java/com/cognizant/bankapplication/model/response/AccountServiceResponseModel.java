package com.cognizant.bankapplication.model.response;

public class AccountServiceResponseModel {
	
	
	private String message;
	private Long accountId;

	

	public AccountServiceResponseModel(String message, Long accountId) {
		super();
		this.message = message;
		this.accountId = accountId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
