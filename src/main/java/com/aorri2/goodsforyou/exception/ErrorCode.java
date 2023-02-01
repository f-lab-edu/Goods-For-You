package com.aorri2.goodsforyou.exception;

public enum ErrorCode {

	//User Error Code
	DUPLICATED_EMAIL("이미 존재하는 이메일 입니다."),
	DUPLICATED_NAME("이미 존재하는 닉네임 입니다."),
	INVALID_PASSWORD("패스워드는 8자리 이상 입니다.");

	private final String message;

	ErrorCode(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
