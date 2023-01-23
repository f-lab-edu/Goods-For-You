package com.aorri2.goodsforyou.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.application.NewUserCreator;
import com.aorri2.goodsforyou.user.infrastructure.UserRepositoryAdapter;
import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepository;

@DisplayName("NewUserCreator 클래스")
class NewUserCreatorTest {

	MemoryUserRepository memoryUserRepository;

	UserRepositoryPort userRepositoryPort;

	NewUserCreator newUserCreator;

	@BeforeEach
	void setUp() {
		memoryUserRepository = new MemoryUserRepository();
		userRepositoryPort = new UserRepositoryAdapter(memoryUserRepository);
		newUserCreator = new NewUserCreator(userRepositoryPort);
	}

	@Nested
	@DisplayName("save 메소드는")
	class Describe_save {

		@Nested
		@DisplayName("user 객체를")
		class Context_with_user {
			@Test
			@DisplayName("사용자가 입력한 값으로 저장한다.")
			void it_save_userInput() {
				User user = new NewUser("wook@.naver.com", "jong", "1232131");

				newUserCreator.save(user);

				User foundUser = memoryUserRepository.findByName("jong");

				assertThat(foundUser).isEqualTo(user);
			}
		}
	}
}