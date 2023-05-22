package com.cognizant.bankapplication.Exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.bankapplication.model.response.AccountServiceResponseModel;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<AccountServiceResponseModel> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		logger.trace(message);
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new AccountServiceResponseModel(message));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		{
			Map<String, String> resp = new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				resp.put(fieldName, message);
				logger.trace(message);
			});
			return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
		}
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<AccountServiceResponseModel> HttpMessageNotReadableExceptionExceptionHandler(HttpMessageNotReadableException ex) {
		
	//	throw new MethodArgumentNotValidException();
		logger.trace(ex.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new AccountServiceResponseModel(ex.getLocalizedMessage()));
		

	}
}
