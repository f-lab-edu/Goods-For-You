package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;

public class UnAuthorizedUserAccessException extends UserException {
	public UnAuthorizedUserAccessException() {
		super(ErrorCode.UNAUTHORIZED_USER);
	}

}
