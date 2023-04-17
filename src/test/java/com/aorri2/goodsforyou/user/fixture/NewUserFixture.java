package com.aorri2.goodsforyou.user.fixture;

import com.aorri2.goodsforyou.user.presentation.request.NewUserRequest;

public enum NewUserFixture {

	회원가입_요청_정상("test@test.com", "test", "test12345678");

	private final String email;
	private final String name;
	private final String password;

	NewUserFixture(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	private String 이메일() {
		return this.email;
	}

	private String 이름() {
		return this.name;
	}

	private String 패스워드() {
		return this.password;
	}

	public NewUserRequest 회원가입_요청_생성() {
		return new NewUserRequest(이메일(), 이름(), 패스워드());
	}
}
