package com.aorri2.goodsforyou.user.fixture;

import com.aorri2.goodsforyou.user.presentation.request.LoginUserRequest;

public enum LoginUserFixture {
	로그인_유저_요청_정상("test@test.com", "test12345678");

	private final String email;
	private final String password;

	LoginUserFixture(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String 이메일() {
		return email;
	}

	public String 패스워드() {
		return password;
	}

	public LoginUserRequest 로그인_유저_요청_생성() {
		return new LoginUserRequest(이메일(), 패스워드());
	}
}
