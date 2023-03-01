package com.aorri2.goodsforyou.user.presentation.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aorri2.goodsforyou.common.domain.ErrorResult;
import com.aorri2.goodsforyou.user.domain.exception.UserException;

@RestControllerAdvice
public class UserControllerAdvice {
	@ExceptionHandler(UserException.class)
	protected ResponseEntity<ErrorResult> handleUserException(UserException e) {
		ErrorResult result = new ErrorResult("USER-002", e.getMessage());
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
