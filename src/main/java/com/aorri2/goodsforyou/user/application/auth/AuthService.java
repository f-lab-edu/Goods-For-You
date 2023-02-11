package com.aorri2.goodsforyou.user.application.auth;

public interface AuthService {

	void login(String token);

	void logout();
}
