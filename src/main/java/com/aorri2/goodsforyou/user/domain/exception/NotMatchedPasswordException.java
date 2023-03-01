package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;

public class NotMatchedPasswordException extends UserException {
	public NotMatchedPasswordException() {
		super(ErrorCode.NOT_MATCHED_PASSWORD);
	}
}
