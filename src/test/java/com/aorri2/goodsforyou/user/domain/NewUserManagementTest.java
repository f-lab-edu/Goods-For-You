package com.aorri2.goodsforyou.user.domain;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@DisplayName("NewUserManagement 클래스")
class NewUserManagementTest {
	/**
	 * 애노테이션이 붙은 해당 필드를 목 객체로 만들어 준다.
	 * Mock 또는 모의 객체는 테스트를 수행할 모듈과 연결되는 외부의 다른 서비스나 모둘듈을 실제 사용하는 모듈들을 사용하지 않고
	 * 실제의 모듈을 "흉내"내는 "가짜" 모듈을 작성하여 테스트의 효용성을 높여주는 객체이다.
	 */
	@Mock
	UserValidator validator;
	@Mock
	UserCreator creator;
	/**
	 * @Mock 이 붙은 목객체를 @InjectMocks 가 붙은 객체에 주입시켜 주는 애노테이션
	 */
	@InjectMocks
	NewUserManagement userManagement;

	/**
	 * 해당 애노테이션을 붙인 메서드는 각각의 테스트 메서드 실행 이전에 수행됩니다.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); // 테스트 클래스의 @InjectMocks이 붙은 필드에 @Mock이 붙은 모든 필드를 주입
		userManagement = new NewUserManagement(creator, validator);
	}

	/**
	 * 해당 애노테이션을 붙임으로, 시각적으로 계층적으로 보이는 테스트 코드를 작성할 수 있습니다.
	 */
	@Nested
	@DisplayName("joinUser 메소드는")
	class joinUser_of {
		@Test
		@DisplayName("validator를 1번 호출하고")
		void executeValidator_whenJoinUserIsValid() {
			User user = mock(User.class);
			userManagement.joinUser(user);
			verify(validator, times(1)).checkUserValidity(user);
		}

		@Test
		@DisplayName("creator도 1번 호출한다.")
		void andExecuteCreator() {
			User user = mock(User.class);
			userManagement.joinUser(user);
			verify(creator, times(1)).save(user);
		}
	}

}