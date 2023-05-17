package com.cognizant.bankapplication.Exception;

public class ResourceNotFoundException extends RuntimeException {

	private String resourceName;
	private long fieldValue;
	private Object fieldName;
	public ResourceNotFoundException(String resourceName, long fieldValue, String fieldName) {
		super(String.format("%s not found with %s: %s", resourceName, fieldValue, fieldName));
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
		this.fieldName = fieldName;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public long getFieldValue() {
		return fieldValue;
	}
	
	public Object getFieldName() {
		return fieldName;
	}
	
	
}
