package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;

public class InvalidPasswordException extends UserException {

	public InvalidPasswordException() {
		super(ErrorCode.INVALID_PASSWORD);
	}

}
