package com.aorri2.goodsforyou.user.domain.exception;

import com.aorri2.goodsforyou.exception.BaseException;
import com.aorri2.goodsforyou.exception.ErrorCode;

public class DuplicatedNameException extends BaseException {

	public DuplicatedNameException() {
		super(ErrorCode.DUPLICATED_NAME);
	}

}
