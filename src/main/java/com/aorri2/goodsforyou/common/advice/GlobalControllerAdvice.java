package com.aorri2.goodsforyou.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aorri2.goodsforyou.common.domain.ErrorResult;

@RestControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		ErrorResult result = new ErrorResult("USER-001", e.getFieldError().getDefaultMessage());
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
