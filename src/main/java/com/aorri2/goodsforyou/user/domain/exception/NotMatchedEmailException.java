package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;

public class NotMatchedEmailException extends UserException {

	public NotMatchedEmailException() {
		super(ErrorCode.NOT_MATCHED_EMAIL);
	}
}
