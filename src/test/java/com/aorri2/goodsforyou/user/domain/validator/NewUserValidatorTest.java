package com.aorri2.goodsforyou.user.domain.validator;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserPolicy;

@DisplayName("NewUserEmailPolicy 클래스")
class NewUserValidatorTest {

	@Mock
	List<UserPolicy> validityPolicyList = new ArrayList<>();
	@InjectMocks
	NewUserValidator validator;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Nested
	@DisplayName("checkUserValidity메소드는")
	class Describe_checkUserValidity {

		@Nested
		@DisplayName("user 객체를 ")
		class Context_with_user {
			@Test
			@DisplayName("policy 구현체 만큼 실행한다.")
			void it_execute_policySize() {
				User user = mock(User.class);
				when(user.name()).thenReturn("test");
				when(user.email()).thenReturn("testas");
				when(user.password()).thenReturn("test123");
				validator.checkUserValidity(user);
				verify(user, times(3));
			}
		}
	}
}