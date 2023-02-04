package com.aorri2.goodsforyou.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aorri2.goodsforyou.common.domain.ErrorResult;
import com.aorri2.goodsforyou.exception.BaseException;

@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		ErrorResult result = new ErrorResult("USER-001", e.getFieldError().getDefaultMessage());
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BaseException.class)
	/**
	 * handleBaseException 애플리케이션에서 발생한 에러를 처리하는 메서드
	 */
	protected ResponseEntity<ErrorResult> handleBaseException(BaseException e) {
		ErrorResult result = new ErrorResult("USER-002", e.getMessage());
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}

}
