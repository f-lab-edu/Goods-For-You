package com.aorri2.goodsforyou.productimage.domain.exception;

import com.aorri2.goodsforyou.common.exception.ErrorCode;

public class UnSupportedFileTypeException extends ProductImageException {
	public UnSupportedFileTypeException() {
		super(ErrorCode.NOT_SUPPORTED_FILE_TYPE);
	}
}
