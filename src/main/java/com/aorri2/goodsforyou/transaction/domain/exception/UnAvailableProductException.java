package com.aorri2.goodsforyou.transaction.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;

public class UnAvailableProductException extends TransactionException {
	public UnAvailableProductException() {
		super(ErrorCode.UNAVAILABLE_PRODUCT);
	}
}
