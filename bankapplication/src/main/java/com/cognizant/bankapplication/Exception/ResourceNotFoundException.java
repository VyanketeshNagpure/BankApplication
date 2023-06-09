package com.cognizant.bankapplication.Exception;

import java.math.BigInteger;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private BigInteger fieldValue;
	private Object fieldName;

	public ResourceNotFoundException(String resourceName, BigInteger fieldValue, String fieldName) {
		super(new String(resourceName+" not found with " +fieldName+": " +fieldValue));
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
		this.fieldName = fieldName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public BigInteger getFieldValue() {
		return fieldValue;
	}

	public Object getFieldName() {
		return fieldName;
	}

}
