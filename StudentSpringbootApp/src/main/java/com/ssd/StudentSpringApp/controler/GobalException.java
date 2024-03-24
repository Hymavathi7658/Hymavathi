package com.ssd.StudentSpringApp.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ssd.StudentSpringApp.exceptions.EmailException;

@RestControllerAdvice
@RestController
public class GobalException extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> getEmailException(EmailException exp, WebRequest req) {
		return new ResponseEntity(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
