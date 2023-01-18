package com.aorri2.goodsforyou.user.domain.policy;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;

@DisplayName("NewUserNamePolicyTest 클래스")
class NewUserNamePolicyTest {
	@Mock
	UserFinder finder;

	@InjectMocks
	NewUserNamePolicy policy;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		policy = new NewUserNamePolicy(finder);
	}

	@Nested
	@DisplayName("apply메소드는")
	class Describe_apply {

		@Nested
		@DisplayName("만약 유저의 닉네임이 존재한다면")
		class Context_with_nameAlreadyExist {
			@Test
			@DisplayName("RuntimeException을 던진다")
			void it_throws_RuntimeException() {
				User user = mock(User.class);
				when(user.name()).thenReturn("닉네임");
				when(finder.findByName(user.name())).thenReturn(user);

				assertThatThrownBy(() -> policy.apply(user)).isInstanceOf(RuntimeException.class);
			}
		}
	}
}