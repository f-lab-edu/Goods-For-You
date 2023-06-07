package com.aorri2.goodsforyou.productimage.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;
import com.aorri2.goodsforyou.common.exception.GoodsForYouException;

public class ProductImageException extends GoodsForYouException {
	public ProductImageException(ErrorCode errorCode) {
		super(errorCode);
	}
}
