package com.aorri2.goodsforyou.product.presentation.advice;

import static com.aorri2.goodsforyou.common.utils.ExceptionLogHelper.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aorri2.goodsforyou.common.domain.ErrorResult;
import com.aorri2.goodsforyou.product.domain.exception.ProductException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ProductControllerAdvice {
	@ExceptionHandler(ProductException.class)
	protected ResponseEntity<ErrorResult> handleProductException(ProductException e) {
		ErrorResult result = new ErrorResult("PRODUCT-001", e.getMessage());
		makeExcepetionLog(log, e, result);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
