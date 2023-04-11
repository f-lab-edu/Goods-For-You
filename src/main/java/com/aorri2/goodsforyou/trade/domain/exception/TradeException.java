package com.aorri2.goodsforyou.trade.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;
import com.aorri2.goodsforyou.common.exception.GoodsForYouException;

public class TradeException extends GoodsForYouException {

	public TradeException(ErrorCode errorCode) {
		super(errorCode);
	}
}
