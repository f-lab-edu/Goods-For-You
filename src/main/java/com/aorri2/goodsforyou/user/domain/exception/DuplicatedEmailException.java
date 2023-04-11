package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;

public class DuplicatedEmailException extends UserException {

	public DuplicatedEmailException() {
		super(ErrorCode.DUPLICATED_EMAIL);
	}

}
