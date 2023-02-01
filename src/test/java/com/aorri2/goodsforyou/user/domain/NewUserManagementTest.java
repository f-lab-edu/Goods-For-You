package com.aorri2.goodsforyou.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.application.NewUserCreator;
import com.aorri2.goodsforyou.user.application.NewUserFinder;
import com.aorri2.goodsforyou.user.application.NewUserValidator;
import com.aorri2.goodsforyou.user.application.UserManagement;
import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.application.facade.NewUserManagement;
import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepositoryAdapter;

@DisplayName("NewUserManagement 클래스")
class NewUserManagementTest {

	UserValidator validator;
	NewUserCreator creator;
	UserFinder finder;
	UserManagement userManagement;
	UserRepositoryPort userRepositoryPort;
	CreateUserCommand user;

	@BeforeEach
	void setUp() {
		userRepositoryPort = new MemoryUserRepositoryAdapter();
		creator = new NewUserCreator(userRepositoryPort);
		finder = new NewUserFinder(userRepositoryPort);
		validator = new NewUserValidator(finder);
		userManagement = new NewUserManagement(creator, validator);

		user = new CreateUserCommand("goods@naver.com", "goods", "123123123");
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

				userManagement.joinUser(user);
				User foundUser = userRepositoryPort.findByName("goods");

				assertThat(foundUser).isNotNull();
				assertThat(foundUser.name()).isEqualTo(user.getName());
			}
		}
	}

}