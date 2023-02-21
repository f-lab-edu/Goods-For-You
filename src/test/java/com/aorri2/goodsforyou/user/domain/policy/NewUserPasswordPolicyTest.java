package com.aorri2.goodsforyou.user.domain.policy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.application.policy.NewUserPasswordPolicy;
import com.aorri2.goodsforyou.user.domain.NewUser;
import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.exception.InvalidPasswordException;

@DisplayName("NewUserPasswordPolicyTest 클래스")
class NewUserPasswordPolicyTest {

	NewUserPasswordPolicy policy;

	@BeforeEach
	void setUp() {
		policy = new NewUserPasswordPolicy();
	}

	@Nested
	@DisplayName("apply메소드는")
	class Describe_apply {

		@Nested
		@DisplayName("만약 패스워드가 8자리 이하라면")
		class Context_with_password_LessThan_8 {
			@Test
			@DisplayName("InvalidPasswordException을 던진다")
			void it_throws_RuntimeException() {
				User user = new NewUser("wook@naver.com", "wook", "123123");

				assertThatThrownBy(() -> policy.apply(user)).isInstanceOf(InvalidPasswordException.class);
			}
		}
	}
}