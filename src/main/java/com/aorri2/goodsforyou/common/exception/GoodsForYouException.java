package com.aorri2.goodsforyou.common.exception;

/**
 * 추후 CustomeException이 증가함에 따라, 분류하기 편하게, 그리고 재사용성을 증가시키기 위해
 * BaseException이라는 커스텀 예외들의 상위 클래스를 만들어 관리
 */
public class GoodsForYouException extends RuntimeException {

	private final ErrorCode errorCode;

	public GoodsForYouException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

}
