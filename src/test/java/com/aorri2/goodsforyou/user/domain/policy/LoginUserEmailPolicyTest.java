package com.aorri2.goodsforyou.user.domain.policy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.application.NewUserFinder;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;
import com.aorri2.goodsforyou.user.application.policy.LoginUserEmailPolicy;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserRepositoryPort;
import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepositoryAdapter;

@DisplayName("LoginUserEmailPolicy 클래스")
class LoginUserEmailPolicyTest {

	UserFinder finder;

	LoginUserEmailPolicy policy;

	UserRepositoryPort userRepositoryPort;

	@BeforeEach
	void setUp() {
		userRepositoryPort = new MemoryUserRepositoryAdapter();
		finder = new NewUserFinder(userRepositoryPort);
		policy = new LoginUserEmailPolicy(finder);
	}

	@Nested
	@DisplayName("apply메소드는")
	class Describe_apply {

		@Nested
		@DisplayName("만약 유저의 이메일이 존재하지 않는다면")
		class Context_with_emailIsNotExist {

			@Test
			@DisplayName("RuntimeException을 던진다")
			void it_throws_RuntimeException() {

				LoginUserCommand loginUserCommand = new LoginUserCommand("test@test.com", "testtest");

				assertThatThrownBy(() -> policy.apply(loginUserCommand))
					.isInstanceOf(RuntimeException.class);
			}

			@Test
			@DisplayName("'유효하지 않은 회원 이메일 입니다.'라는 에러 메시지를 가진다")
			void it_has_customErrorMessage() {
				LoginUserCommand loginUserCommand = new LoginUserCommand("test@test.com", "testtest");
				assertThatThrownBy(() -> policy.apply(loginUserCommand))
					.isInstanceOf(RuntimeException.class).hasMessage("유효하지 않은 회원 이메일 입니다.");
			}

		}
	}

}