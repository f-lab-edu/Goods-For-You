package com.aorri2.goodsforyou.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.application.NewUserCreator;
import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepositoryAdapter;

@DisplayName("NewUserCreator 클래스")
class NewUserCreatorTest {

	MemoryUserRepositoryAdapter memoryUserRepositoryAdapter;
	UserRepositoryPort userRepositoryPort;
	CreateUserCommand user;
	NewUserCreator newUserCreator;

	@BeforeEach
	void setUp() {
		user = new CreateUserCommand("wook@.naver.com", "jongwuk", "1232131");
		memoryUserRepositoryAdapter = new MemoryUserRepositoryAdapter();
		userRepositoryPort = memoryUserRepositoryAdapter;
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

				newUserCreator.save(user.toEntity());

				User foundUser = userRepositoryPort.findByName("jongwuk");

				assertThat(foundUser.name()).isEqualTo(user.getName());
			}
		}
	}
}