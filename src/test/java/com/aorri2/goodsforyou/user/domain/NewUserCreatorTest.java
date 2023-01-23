package com.aorri2.goodsforyou.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.domain.user.NewUser;

@DisplayName("NewUserCreator 클래스")
class NewUserCreatorTest {

	MemoryUserRepository memoryUserRepository;

	NewUserCreator newUserCreator;

	@BeforeEach
	void setUp() {
		memoryUserRepository = new MemoryUserRepository();
		newUserCreator = new NewUserCreator(memoryUserRepository);
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