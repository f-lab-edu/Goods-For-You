package com.aorri2.goodsforyou.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aorri2.goodsforyou.common.domain.ErrorResult;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		String className = e.getParameter().getMethod().getDeclaringClass().getSimpleName();
		String methodName = e.getParameter().getMethod().getName();
		String defaultMessage = e.getFieldError().getDefaultMessage();

		ErrorResult result = new ErrorResult("USER-001", defaultMessage);

		log.error("Exception Occurred in {}.{}(). Error message: {}", className, methodName, defaultMessage);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
