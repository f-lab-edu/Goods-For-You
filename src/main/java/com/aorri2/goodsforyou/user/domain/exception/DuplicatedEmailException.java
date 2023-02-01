package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.exception.BaseException;
import com.aorri2.goodsforyou.exception.ErrorCode;

public class DuplicatedEmailException extends BaseException {

	public DuplicatedEmailException() {
		super(ErrorCode.DUPLICATED_EMAIL);
	}

}
