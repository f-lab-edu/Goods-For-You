package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.exception.BaseException;
import com.aorri2.goodsforyou.exception.ErrorCode;

public class HasDuplicatedEmailException extends BaseException {

	public HasDuplicatedEmailException() {
		super(ErrorCode.DUPLICATED_EMAIL);
	}

}
