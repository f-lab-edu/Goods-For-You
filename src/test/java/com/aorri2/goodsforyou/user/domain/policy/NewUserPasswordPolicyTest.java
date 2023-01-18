package com.aorri2.goodsforyou.user.domain.policy;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.aorri2.goodsforyou.user.domain.User;

@DisplayName("NewUserPasswordPolicyTest 클래스")
class NewUserPasswordPolicyTest {
	@InjectMocks
	NewUserPasswordPolicy policy;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Nested
	@DisplayName("apply메소드는")
	class Describe_apply {

		@Nested
		@DisplayName("만약 패스워드가 8자리 이하라면")
		class Context_with_password_LessThan_8 {
			@Test
			@DisplayName("RuntimeException을 던진다")
			void it_throws_RuntimeException() {
				User user = mock(User.class);
				when(user.password()).thenReturn("12344");

				assertThatThrownBy(() -> policy.apply(user)).isInstanceOf(RuntimeException.class);
			}
		}
	}
}