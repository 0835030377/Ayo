package com.ayo.assessment.exceptions;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerManager extends ResponseEntityExceptionHandler{
	ErrorMessage em;
	
	@ExceptionHandler(value={Exception.class})
	public ResponseEntity<Object> handleAllExceptions(Exception e,WebRequest req){
		
		String emessage = e.getLocalizedMessage();
		if (emessage == null) {
			
		} else {
		 em = new ErrorMessage(new Date(),emessage);
		}
		return new ResponseEntity<>(em,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(value={NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(Exception e,WebRequest req){
		
		String emessage = e.getLocalizedMessage();
		if (emessage == null) {
			emessage= e.toString();
		} else {
		 em = new ErrorMessage(new Date(),emessage);
		}
		return new ResponseEntity<>(em,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
