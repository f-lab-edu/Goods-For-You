package com.aorri2.goodsforyou.user.application.auth;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;

@DisplayName("SessionAuthService 테스트")
class SessionAuthServiceTest {

	private MockHttpSession session;

	private SessionAuthService sessionAuthService;

	@BeforeEach
	void setUp() {
		session = new MockHttpSession();
		sessionAuthService = new SessionAuthService(session);
	}

	@Nested
	/*
	ReplaceUnderScores '_'로 되어있는 문자를 ' ' 공백으로 바꿔줍니다.
	@DisplayNameGeneration 은 어노테이션이 달린 테스트 클래스에 대해 사용자가 지정한 DisplayNameGenerator를 이용해 테스트 이름을 표시해 줍니다.
	 */
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class 회원_로그인_메서드는 {
		@Nested
		@DisplayName("토큰 정보가 주어지면")
		class context_with_token_info {

			@Test
			@DisplayName("해당 토큰을 세션에 저장한다.")
			void it_save_token_session() {
				String token = "dummyToken";

				sessionAuthService.login(token);
				String sessionId = session.getAttribute("sessionId").toString();
				assertThat(sessionId).isEqualTo(token);
			}
		}
	}

	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class 회원_로그아웃_메서드는 {

		@Nested
		@DisplayName("세션 ID값이 주어지면")
		class context_with_sessionId {
			@Test
			@DisplayName("해당 세션 ID값의 토큰을 삭제한다.")
			void it_remove_token() {
				session.setAttribute("sessionId", "Dummytoken");

				sessionAuthService.logout();

				Object sessionToken = session.getAttribute("sessionId");
				assertThat(sessionToken).isNull();
			}
		}
	}
}