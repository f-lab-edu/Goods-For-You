package com.aorri2.goodsforyou.common.exception;

public enum ErrorCode {

	//User Error Code
	DUPLICATED_EMAIL("이미 존재하는 이메일 입니다."),
	DUPLICATED_NAME("이미 존재하는 닉네임 입니다."),
	INVALID_PASSWORD("패스워드는 8자리 이상 입니다."),
	NOT_MATCHED_PASSWORD("패스워드가 일치하지 않습니다."),
	NOT_MATCHED_EMAIL("이메일이 일치하지 않습니다."),
	UNAUTHORIZED_USER("인가되지 않은 사용자 입니다."),

	//Product Error Code
	NOT_EXIST_PRODUCT("해당 상품은 존재하지 않습니다."),

	//Trade Error Code
	ALREADY_SOLD_PRODUCT("이미 판매 완료된 상품 입니다."),
	;

	private final String message;

	ErrorCode(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
