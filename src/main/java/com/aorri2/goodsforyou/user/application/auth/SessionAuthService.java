package com.aorri2.goodsforyou.user.application.auth;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionAuthService implements AuthService {

	public static final String SESSION_ID = "sessionId";
	private final HttpSession session;

	public SessionAuthService(HttpSession session) {
		this.session = session;
	}

	@Override
	public void login(String token) {
		session.setAttribute(SESSION_ID, token);
	}

	@Override
	public void logout() {
		session.removeAttribute(SESSION_ID);
	}
}
