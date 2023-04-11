package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;
import com.aorri2.goodsforyou.common.exception.GoodsForYouException;

public class UserException extends GoodsForYouException {
	public UserException(ErrorCode errorCode) {
		super(errorCode);
	}
}
