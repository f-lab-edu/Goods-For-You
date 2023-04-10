package com.aorri2.goodsforyou.trade.presentation.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aorri2.goodsforyou.common.domain.ErrorResult;
import com.aorri2.goodsforyou.trade.domain.exception.TradeException;

@RestControllerAdvice
public class TradeControllerAdvice {

	@ExceptionHandler(TradeException.class)
	protected ResponseEntity<ErrorResult> handleTradeException(TradeException e) {
		ErrorResult result = new ErrorResult("TRADE-001", e.getMessage());
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
