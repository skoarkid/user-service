package com.manipal.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> globalException(Exception exception) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({UserNotFoundException.class,BookingNotFoundException.class})
	public ResponseEntity<ExceptionResponse> notFound(Exception exception) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UsernameExistsException.class)
	public ResponseEntity<ExceptionResponse> unavailable(UsernameExistsException exception) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler({IncorrectPasswordException.class ,IncorrectUsernameException.class})
	public ResponseEntity<ExceptionResponse> unavailable(Exception exception) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
	}
}
