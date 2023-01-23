package com.aorri2.goodsforyou.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.application.NewUserCreator;
import com.aorri2.goodsforyou.user.application.NewUserValidator;
import com.aorri2.goodsforyou.user.application.facade.NewUserManagement;
import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepository;

@DisplayName("NewUserManagement 클래스")
class NewUserManagementTest {

	UserValidator validator;
	UserCreator creator;
	UserManagement userManagement;
	MemoryUserRepository userRepository;

	@BeforeEach
	void setUp() {

		userRepository = new MemoryUserRepository();
		userRepository.clear();

		UserCreator userCreator = new NewUserCreator(userRepository);
		UserFinder userFinder = new NewUserFinder(userRepository);
		UserValidator userValidator = new NewUserValidator(userFinder);

		userManagement = new NewUserManagement(userCreator, userValidator);
	}

	/**
	 * 해당 애노테이션을 붙임으로, 시각적으로 계층적으로 보이는 테스트 코드를 작성할 수 있습니다.
	 */
	@Nested
	@DisplayName("joinUser 메소드는")
	class Describe_joinUser {

		@Nested
		@DisplayName("유저정보가 주어진다면")
		class Context_with_userInformation {

			@Test
			@DisplayName("해당 유저 정보를 저장한다.")
			void it_save_that_userInformation() {

				User user = new NewUser("wook@naver.com", "wook", "123123123");

				userManagement.joinUser(user);
				User foundUser = userRepository.findByName("wook");

				assertThat(foundUser).isNotNull();
				assertThat(foundUser.name()).isEqualTo(user.name());
			}
		}
	}

}