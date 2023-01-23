package com.aorri2.goodsforyou.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepository;

@DisplayName("NewUserFinder 클래스")
class NewUserFinderTest {

	UserFinder newUserFinder;
	UserRepositoryPort userRepositoryPort;

	@BeforeEach
	void setUp() {
		userRepositoryPort = new MemoryUserRepository();
		newUserFinder = new NewUserFinder(userRepositoryPort);
	}

	@Nested
	@DisplayName("findByName 메소드는")
	class Describe_findByName {

		@BeforeEach
		void setUp() {
			User user = new NewUser("wook@naver.com", "wook", "123123");
			userRepositoryPort.save(user);
		}

		@Nested
		@DisplayName("만약 일치하는 이름이 있다면")
		class Context_with_correctName {
			@Test
			@DisplayName("이름에 해당하는 유저 객체를 리턴한다.")
			void it_returns_a_correct_user() {

				User foundUser = newUserFinder.findByName("wook");
				assertThat(foundUser).isNotNull();
				assertThat(foundUser.name()).isEqualTo("wook");
			}
		}
	}
}