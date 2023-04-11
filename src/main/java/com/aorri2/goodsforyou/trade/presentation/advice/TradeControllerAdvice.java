package com.aorri2.goodsforyou.trade.presentation.advice;

import static com.aorri2.goodsforyou.common.utils.ExceptionLogHelper.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aorri2.goodsforyou.common.domain.ErrorResult;
import com.aorri2.goodsforyou.trade.domain.exception.TradeException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class TradeControllerAdvice {

	@ExceptionHandler(TradeException.class)
	protected ResponseEntity<ErrorResult> handleTradeException(TradeException e) {
		ErrorResult result = new ErrorResult("TRADE-001", e.getMessage());
		makeExcepetionLog(log, e, result);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
