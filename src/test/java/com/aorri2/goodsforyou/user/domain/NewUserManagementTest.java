package com.aorri2.goodsforyou.user.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;

import com.aorri2.goodsforyou.user.application.NewUserCreator;
import com.aorri2.goodsforyou.user.application.NewUserFinder;
import com.aorri2.goodsforyou.user.application.NewUserValidator;
import com.aorri2.goodsforyou.user.application.UserManagement;
import com.aorri2.goodsforyou.user.application.auth.AuthService;
import com.aorri2.goodsforyou.user.application.auth.SessionAuthService;
import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;
import com.aorri2.goodsforyou.user.application.facade.NewUserManagement;
import com.aorri2.goodsforyou.user.domain.policy.LoginUserEmailPolicy;
import com.aorri2.goodsforyou.user.domain.policy.LoginUserPasswordPolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserEmailPolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserNamePolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserPasswordPolicy;
import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepositoryAdapter;

@DisplayName("NewUserManagement 클래스")
class NewUserManagementTest {

	UserValidator validator;
	NewUserCreator creator;
	UserFinder finder;
	UserManagement userManagement;
	UserRepositoryPort userRepositoryPort;

	List<UserPolicy> validityPolicyList;
	List<LoginUserPolicy> loginUserPolicyList;
	TokenGenerator tokenGenerator;
	AuthService authService;

	MockHttpSession session;
	LoginUserCommand loginuserCommand;

	@BeforeEach
	void setUp() {
		userRepositoryPort = new MemoryUserRepositoryAdapter();
		creator = new NewUserCreator(userRepositoryPort);
		finder = new NewUserFinder(userRepositoryPort);
		validityPolicyList = List.of(new NewUserEmailPolicy(finder), new NewUserNamePolicy(finder),
			new NewUserPasswordPolicy());
		loginUserPolicyList = List.of(new LoginUserEmailPolicy(finder), new LoginUserPasswordPolicy(finder));
		validator = new NewUserValidator(validityPolicyList, loginUserPolicyList);
		tokenGenerator = new UUIDTokenGenerator();
		session = new MockHttpSession();
		authService = new SessionAuthService(session);
		userManagement = new NewUserManagement(creator, validator, tokenGenerator, authService);
		loginuserCommand = new LoginUserCommand("wook@test.com", "123123123");
	}

	private CreateUserCommand makeCreateUserCommand(String email, String name, String password) {
		return new CreateUserCommand(email, name, password);
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
				CreateUserCommand createUserCommand = makeCreateUserCommand("goods@goods.com", "goods", "123123456");
				userManagement.joinUser(createUserCommand);
				User foundUser = userRepositoryPort.findByName("goods");

				assertThat(foundUser).isNotNull();
				assertThat(foundUser.name()).isEqualTo(createUserCommand.getName());
			}
		}
	}

	@Nested
	@DisplayName("loginUser 메소드는")
	class Describe_loginUser {

		@Nested
		@DisplayName("유저정보가 주어진다면")
		class Context_with_userInformation {

			@Test
			@DisplayName("해당 유저 정보를 저장한다.")
			void it_save_that_userInformation() {
				CreateUserCommand createUserCommand = makeCreateUserCommand("wook@test.com", "test", "123123123");
				userManagement.joinUser(createUserCommand);
				String token = userManagement.loginUser(loginuserCommand);

				assertThat(token.getClass()).hasSameClassAs(String.class);

			}
		}
	}

}