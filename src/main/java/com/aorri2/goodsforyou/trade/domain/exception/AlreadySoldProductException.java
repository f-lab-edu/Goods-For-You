package com.aorri2.goodsforyou.trade.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;

public class AlreadySoldProductException extends TradeException {
	public AlreadySoldProductException() {
		super(ErrorCode.ALREADY_SOLD_PRODUCT);
	}
}
