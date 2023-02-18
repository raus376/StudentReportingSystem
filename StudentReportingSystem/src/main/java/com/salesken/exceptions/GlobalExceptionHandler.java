package com.salesken.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception be, WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails();
		err.setTStamp(LocalDateTime.now());
		err.setMessage(be.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> studentExceptionHandler(StudentException be, WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails();
		err.setTStamp(LocalDateTime.now());
		err.setMessage(be.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}

}
