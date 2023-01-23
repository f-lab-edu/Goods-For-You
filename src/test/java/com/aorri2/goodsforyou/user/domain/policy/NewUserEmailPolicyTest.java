package com.aorri2.goodsforyou.user.domain.policy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.domain.MemoryUserRepository;
import com.aorri2.goodsforyou.user.domain.NewUserFinder;
import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserRepository;
import com.aorri2.goodsforyou.user.domain.user.NewUser;

@DisplayName("NewUserEmailPolicy 클래스")
class NewUserEmailPolicyTest {

	UserFinder finder;

	NewUserEmailPolicy policy;

	UserRepository userRepository;

	@BeforeEach
	void setUp() {
		userRepository = new MemoryUserRepository();
		finder = new NewUserFinder(userRepository);
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
				userRepository.save(user);
			}

			@Test
			@DisplayName("RuntimeException을 던진다")
			void it_throws_RuntimeException() {

				User user = new NewUser("wook@naver.com", "wook", "123123");

				assertThatThrownBy(() -> policy.apply(user))
					.isInstanceOf(RuntimeException.class);
			}

			@Test
			@DisplayName("이미 존재하는 이메일 입니다라는 에러 메시지를 가진다")
			void it_has_customErrorMessage() {
				User user = new NewUser("wook@naver.com", "wook", "123123");

				assertThatThrownBy(() -> policy.apply(user))
					.isInstanceOf(RuntimeException.class).hasMessage("이미 존재하는 이메일 입니다.");
			}

		}
	}
}