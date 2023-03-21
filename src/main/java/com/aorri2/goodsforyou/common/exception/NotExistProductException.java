package com.aorri2.goodsforyou.common.exception;

import com.aorri2.goodsforyou.product.domain.exception.ProductException;

public class NotExistProductException extends ProductException {
	public NotExistProductException() {
		super(ErrorCode.NOT_EXIST_PRODUCT);
	}
}
