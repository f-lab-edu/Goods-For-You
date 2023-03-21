package com.aorri2.goodsforyou.product.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;
import com.aorri2.goodsforyou.common.exception.GoodsForYouException;

public class ProductException extends GoodsForYouException {
	public ProductException(ErrorCode errorCode) {
		super(errorCode);
	}
}
