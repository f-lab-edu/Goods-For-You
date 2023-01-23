package com.aorri2.goodsforyou.user.domain.validator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.aorri2.goodsforyou.user.domain.MemoryUserRepository;
import com.aorri2.goodsforyou.user.domain.NewUserFinder;
import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserPolicy;
import com.aorri2.goodsforyou.user.domain.UserRepository;
import com.aorri2.goodsforyou.user.domain.policy.NewUserEmailPolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserNamePolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserPasswordPolicy;
import com.aorri2.goodsforyou.user.domain.user.NewUser;

@DisplayName("NewUserValidator 클래스")
class NewUserValidatorTest {

	List<UserPolicy> validityPolicyList;

	NewUserValidator validator;

	UserFinder userFinder;
	UserRepository userRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		validityPolicyList = List.of(new NewUserEmailPolicy(userFinder), new NewUserNamePolicy(userFinder),
			new NewUserPasswordPolicy());
		userRepository = new MemoryUserRepository();
		userFinder = new NewUserFinder(userRepository);
		validator = new NewUserValidator(userFinder);
	}

	@Nested
	@DisplayName("checkUserValidity메소드는")
	class Describe_checkUserValidity {

		@Nested
		@DisplayName("만약 이메일과 이름이 중복된다면 ")
		class Context_with_ {
			@BeforeEach
			void setUp() {
				userRepository.save(new NewUser("wook@naver.com", "wook", "123123121"));
			}

			@Test
			@DisplayName("RuntimeException을 발생시킨다.")
			void it_execute_policySize() {
				User user = new NewUser("wook@naver.com", "wook", "123123121");

				assertThatThrownBy(() -> validator.checkUserValidity(user)).isInstanceOf(RuntimeException.class)
					.hasMessage("이미 존재하는 이메일 입니다.");
			}
		}
	}
}