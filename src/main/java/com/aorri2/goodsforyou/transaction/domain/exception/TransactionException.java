package com.aorri2.goodsforyou.transaction.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;
import com.aorri2.goodsforyou.common.exception.GoodsForYouException;

public class TransactionException extends GoodsForYouException {

	public TransactionException(ErrorCode errorCode) {
		super(errorCode);
	}
}
