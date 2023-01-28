package com.aorri2.goodsforyou.user.domain.policy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.application.NewUserFinder;
import com.aorri2.goodsforyou.user.domain.NewUser;
import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserRepositoryPort;
import com.aorri2.goodsforyou.user.domain.exception.HasDuplicatedEmailException;
import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepositoryAdapter;

@DisplayName("NewUserEmailPolicy 클래스")
class NewUserEmailPolicyTest {

	UserFinder finder;

	NewUserEmailPolicy policy;

	UserRepositoryPort userRepositoryPort;

	@BeforeEach
	void setUp() {
		userRepositoryPort = new MemoryUserRepositoryAdapter();
		finder = new NewUserFinder(userRepositoryPort);
		policy = new NewUserEmailPolicy(finder);
	}

	@Nested
	@DisplayName("apply메소드는")
	class Describe_apply {

		@Nested
		@DisplayName("만약 유저의 이메일이 존재한다면")
		class Context_with_emailAlreadyExist {
			User user;

			@BeforeEach
			void setUp() {
				user = new NewUser("wook@naver.com", "wook", "123123");
				userRepositoryPort.save(user);
			}

			@Test
			@DisplayName("HasDuplicatedEmailException을 던진다")
			void it_throws_HasDuplicatedEmailException() {

				User user = new NewUser("wook@naver.com", "wook", "123123");

				assertThatThrownBy(() -> policy.apply(user))
					.isInstanceOf(HasDuplicatedEmailException.class);
			}

			@Test
			@DisplayName("이미 존재하는 이메일 입니다라는 에러 메시지를 가진다")
			void it_has_customErrorMessage() {
				User user = new NewUser("wook@naver.com", "wook", "123123");

				assertThatThrownBy(() -> policy.apply(user))
					.isInstanceOf(HasDuplicatedEmailException.class).hasMessage("이미 존재하는 이메일 입니다.");
			}

		}
	}
}