package com.wns.assessment.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.wns.assessment.exception.ServiceException;
import com.wns.assessment.model.MigrateResponse;

@ControllerAdvice
public class GlobalExceptionhandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public MigrateResponse handleRuntimeException(RuntimeException ex) {
		MigrateResponse migrateResponse = new MigrateResponse();
		migrateResponse.setSuccess(false);
		migrateResponse.setMessage(ex.getMessage());
		return migrateResponse;
	}
	
	@ExceptionHandler(ServiceException.class)
	//@ResponseStatus(HttpStatus.FORBIDDEN)
	public ResponseEntity<MigrateResponse> handleServiceException(ServiceException ex) {
		MigrateResponse migrateResponse = new MigrateResponse();
		migrateResponse.setSuccess(false);
		migrateResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MigrateResponse>(migrateResponse,HttpStatus.FORBIDDEN);
		
	}
}
