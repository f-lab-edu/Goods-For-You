package com.aorri2.goodsforyou.utils;

import org.springframework.mock.web.MockHttpSession;

public class SessionUtil {
	public static MockHttpSession makeMockSession() {
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("sessionId", "token");
		return session;
	}
}