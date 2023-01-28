package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.exception.BaseException;
import com.aorri2.goodsforyou.exception.ErrorCode;

public class HasDuplicatedNameException extends BaseException {

	public HasDuplicatedNameException() {
		super(ErrorCode.DUPLICATED_NAME);
	}

}
