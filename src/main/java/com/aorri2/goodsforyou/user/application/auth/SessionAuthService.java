package com.aorri2.goodsforyou.user.application.auth;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionAuthService implements AuthService {

	private final HttpSession session;

	public SessionAuthService(HttpSession session) {
		this.session = session;
	}

	@Override
	public void login(String token) {
		session.setAttribute("sessionId", token);
	}

	@Override
	public void logout() {
		session.removeAttribute("sessionId");
	}
}
