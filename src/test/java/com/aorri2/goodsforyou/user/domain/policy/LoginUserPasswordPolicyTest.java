package com.aorri2.goodsforyou.user.domain.policy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.application.NewUserFinder;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;
import com.aorri2.goodsforyou.user.domain.NewUser;
import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserRepositoryPort;
import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepositoryAdapter;

@DisplayName("LoginUserPasswordPolicy 클래스")
class LoginUserPasswordPolicyTest {

	UserFinder finder;

	LoginUserPasswordPolicy policy;

	UserRepositoryPort userRepositoryPort;

	@BeforeEach
	void setUp() {
		userRepositoryPort = new MemoryUserRepositoryAdapter();
		finder = new NewUserFinder(userRepositoryPort);
		policy = new LoginUserPasswordPolicy(finder);
	}

	@Nested
	@DisplayName("apply메소드는")
	class Describe_apply {

		User user;

		@Nested
		@DisplayName("만약 유저의 패스워드가 일치하지 않는다면")
		class Context_with_emailIsNotExist {

			@BeforeEach
			void setUp() {
				user = new NewUser("test@test.com", "wook", "123123");
				userRepositoryPort.save(user);
			}

			@Test
			@DisplayName("RuntimeException을 던진다")
			void it_throws_RuntimeException() {

				LoginUserCommand loginUserCommand = new LoginUserCommand("test@test.com", "testtest");

				assertThatThrownBy(() -> policy.apply(loginUserCommand))
					.isInstanceOf(RuntimeException.class);
			}

			@Test
			@DisplayName("'비밀번호가 일치하지 않습니다.'라는 에러 메시지를 가진다")
			void it_has_customErrorMessage() {
				LoginUserCommand loginUserCommand = new LoginUserCommand("test@test.com", "testtest");
				assertThatThrownBy(() -> policy.apply(loginUserCommand))
					.isInstanceOf(RuntimeException.class).hasMessage("비밀번호가 일치하지 않습니다.");
			}

		}
	}

}