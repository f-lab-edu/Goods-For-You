package com.aorri2.goodsforyou.transaction.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;

public class AlreadySoldProductException extends TransactionException {
	public AlreadySoldProductException() {
		super(ErrorCode.ALREADY_SOLD_PRODUCT);
	}
}
