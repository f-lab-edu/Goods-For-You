package com.aorri2.goodsforyou.common.domain;

/**
 * 사용자한테 전달 될 에러 응답 형식
 * 해당 에러의 에러 코드와, 에러 메시지를 넘겨주는 방식
 * kakao REST API 레퍼런스 참고했습니다
 */
public class ErrorResult {

	/**
	 * 'USER-001'과 같이 에러 코드를 나타내는 변수
	 */
	private final String code;
	/**
	 * 발생한 에러의 원인에 대한 참고 정보로 사용될 수 있는 메시지
	 */
	private final String message;

	public ErrorResult(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
