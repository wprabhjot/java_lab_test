package com.traineemgmtspring.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.traineemgmtspring.dto.ErrorInfo;
import com.traineemgmtspring.exceptions.TraineeDataAccessException;

@RestControllerAdvice
public class ExceptionHandlerController {

	@Value("${TRAINEE_NOT_FOUND_MESSAGE}")
	private String errorMessage404;
	
	@Value("${INTERNAL_SERVER_ERROR_MESSAGE}")
	private String errorMessage500;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> handle400(MethodArgumentNotValidException e) {
		String errorMessage= e.getBindingResult()
				.getAllErrors()
				.stream()
				.map(ex-> ex.getDefaultMessage())
				.collect(Collectors.joining(", "));
		
		ErrorInfo errorInfo=new ErrorInfo(errorMessage, HttpStatus.BAD_REQUEST.toString(),
				"it@yamlsi.com", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
	}

	@ExceptionHandler(TraineeDataAccessException.class)
	public ResponseEntity<ErrorInfo> handle404(TraineeDataAccessException e) {
		ErrorInfo errorInfo=new ErrorInfo(e.getMessage(), HttpStatus.NOT_FOUND.toString(),
				"it@yamlsi.com", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}
}