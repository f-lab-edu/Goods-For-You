package com.aorri2.goodsforyou.user.domain;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aorri2.goodsforyou.user.domain.policy.NewUserEmailPolicy;

@DisplayName("NewUserEmailPolicy 클래스")
class NewUserEmailPolicyTest {

	@Mock
	UserFinder finder;
	@InjectMocks
	NewUserEmailPolicy policy;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		policy = new NewUserEmailPolicy(finder);
	}

	@Nested
	@DisplayName("apply메소드는")
	class Describe_apply {

		@Nested
		@DisplayName("만약 유저의 이메일이 존재한다면")
		class Context_with_emailAlreadyExist {
			@Test
			@DisplayName("RuntimeException을 던진다")
			void it_throws_RuntimeException() {
				User user = mock(User.class);
				when(user.email()).thenReturn("test");
				when(finder.findByEmail(user.email())).thenReturn(user);

				assertThatThrownBy(() -> policy.apply(user))
					.isInstanceOf(RuntimeException.class);
			}

			@Test
			@DisplayName("이미 존재하는 이메일 입니다라는 에러 메시지를 가진다")
			void it_has_customErrorMessage() {
				User user = mock(User.class);
				UserPolicy policy = spy(UserPolicy.class);
				try {
					policy.apply(user);
				} catch (RuntimeException e) {
					assertThat(e.getMessage()).isEqualTo("이미 존재하는 이메일 입니다.");
				}
			}

		}
	}
}