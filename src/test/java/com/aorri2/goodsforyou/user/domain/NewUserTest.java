package com.aorri2.goodsforyou.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("NewUser 클래스")
class NewUserTest {

	@Nested
	@DisplayName("password 메서드는")
	class Describe_password {

		@Nested
		@DisplayName("암호화 된 같은 패스워드를 여러번 호출 해도")
		class Context_with_execute_same_encrypted_password {

			@Test
			@DisplayName("패스워드가 같다는 결과가 나와야 한다")
			void it_assert_same_password() {
				NewUser user = new NewUser("asd123@naver.com", "asd", "12341234");
				assertThat(user.password()).startsWith("$2a");
				assertThat(user.password()).isEqualTo(user.password());
			}
		}
	}

}