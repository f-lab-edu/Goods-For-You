package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.exception.BaseException;
import com.aorri2.goodsforyou.exception.ErrorCode;

public class InvalidPasswordException extends BaseException {

	public InvalidPasswordException() {
		super(ErrorCode.INVALID_PASSWORD);
	}

}
