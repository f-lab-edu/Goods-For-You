package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;

public class DuplicatedNameException extends UserException {

	public DuplicatedNameException() {
		super(ErrorCode.DUPLICATED_NAME);
	}

}
