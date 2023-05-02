package com.aorri2.goodsforyou.productimage.domain.exception;

import java.io.IOException;

import com.aorri2.goodsforyou.common.exception.ErrorCode;
import com.aorri2.goodsforyou.common.exception.GoodsForyouInternalServerException;

public class S3StorageFileNotUploadException extends GoodsForyouInternalServerException {
	public S3StorageFileNotUploadException(IOException e) {
		super(ErrorCode.S3_STORAGE_FILE_NOT_UPLOAD, e);
	}
}
