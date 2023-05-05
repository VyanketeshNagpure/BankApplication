package com.cognizant.bankapplication.model.response;

public class AccountServiceResponseModel {
	
	
	private String message;

	
	public AccountServiceResponseModel(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
