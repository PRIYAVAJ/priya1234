package com.cjc.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cjc.dto.ResponseDto;
import com.cjc.exception.UserNotFoundException;


@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(UserNotFoundException ue)
	{
		ResponseDto rdto=new ResponseDto(ue.getMessage(),new Date());
		return new ResponseEntity<String> (ue.getMessage(),HttpStatus.NOT_FOUND);
	}
}
