package com.aorri2.goodsforyou.transaction.presentation.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aorri2.goodsforyou.common.domain.ErrorResult;
import com.aorri2.goodsforyou.transaction.domain.exception.TransactionException;

public class TransactionControllerAdvice {

	@ExceptionHandler(TransactionException.class)
	protected ResponseEntity<ErrorResult> handleTransactionException(TransactionException e) {
		ErrorResult result = new ErrorResult("TRANSACTION-001", e.getMessage());
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
