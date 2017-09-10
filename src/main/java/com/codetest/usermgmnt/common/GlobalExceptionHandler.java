package com.codetest.usermgmnt.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.codetest.usermgmnt.model.AppError;
import com.codetest.usermgmnt.model.ValidationError;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AuthException.class)
	public ResponseEntity<AppError> handleAuthException(AuthException authException) {
		AppError appError = new AppError();
		appError.setCode(authException.getErrorCode());
		appError.setMessage(authException.getMessage());
		ResponseEntity<AppError> error = new ResponseEntity<AppError>(appError,
				HttpStatus.FORBIDDEN);
		return error;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> handleValidationErrors(
			MethodArgumentNotValidException exception) {
		
		ValidationError errors = new ValidationError();
		BindingResult result = exception.getBindingResult();
		for (FieldError error : result.getFieldErrors()) {
			errors.addError(error.getField(), error.getDefaultMessage());
		}		
		ResponseEntity<ValidationError> error = new ResponseEntity<ValidationError>(errors,
				HttpStatus.BAD_REQUEST);
		return error;
	}
	
	@ExceptionHandler(Exception.class)	
	public ResponseEntity<AppError> handleException(Exception exception) {
		AppError appError = new AppError();
		appError.setCode("SRV_ERR");
		appError.setMessage("application error");
		ResponseEntity<AppError> error = new ResponseEntity<AppError>(appError,
				HttpStatus.SERVICE_UNAVAILABLE);
		return error;
	}

}
