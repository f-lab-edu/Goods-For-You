package com.aorri2.goodsforyou.common.exception;

public class GoodsForyouInternalServerException extends RuntimeException {
	public GoodsForyouInternalServerException(ErrorCode errorCode, Throwable cause) {
		super(errorCode.getMessage(), cause);
	}
}
