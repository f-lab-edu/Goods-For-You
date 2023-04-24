package com.aorri2.goodsforyou.user.presentation.advice;

import static com.aorri2.goodsforyou.common.utils.ExceptionLogHelper.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aorri2.goodsforyou.common.domain.ErrorResult;
import com.aorri2.goodsforyou.user.domain.exception.UnAuthorizedUserAccessException;
import com.aorri2.goodsforyou.user.domain.exception.UserException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class UserControllerAdvice {

	@ExceptionHandler(UserException.class)
	protected ResponseEntity<ErrorResult> handleUserException(UserException e) {
		ErrorResult result = new ErrorResult("USER-002", e.getMessage());
		makeExcepetionLog(log, e, result);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnAuthorizedUserAccessException.class)
	protected ResponseEntity<ErrorResult> handleUnAuthorizedUserAccessException(UnAuthorizedUserAccessException e) {
		ErrorResult result = new ErrorResult("USER-003", e.getMessage());
		makeExcepetionLog(log, e, result);
		return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
	}
}
