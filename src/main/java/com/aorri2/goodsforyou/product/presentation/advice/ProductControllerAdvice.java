package com.aorri2.goodsforyou.product.presentation.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aorri2.goodsforyou.common.domain.ErrorResult;
import com.aorri2.goodsforyou.product.domain.exception.ProductException;

@RestControllerAdvice
public class ProductControllerAdvice {
	@ExceptionHandler(ProductException.class)
	protected ResponseEntity<ErrorResult> handleProductException(ProductException e) {
		ErrorResult result = new ErrorResult("PRODUCT-001", e.getMessage());
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
