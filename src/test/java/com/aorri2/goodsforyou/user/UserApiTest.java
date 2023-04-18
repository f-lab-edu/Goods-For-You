package com.aorri2.goodsforyou.user;

import static com.aorri2.goodsforyou.user.UserSteps.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.aorri2.goodsforyou.ApiTest;
import com.aorri2.goodsforyou.user.presentation.request.NewUserRequest;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@DisplayName("UserApiTest 클래스")
class UserApiTest extends ApiTest {

	@Nested
	@DisplayName("register 메서드는")
	class Describe_register {

		@Nested
		@DisplayName("유저정보가 주어진다면")
		class Context_with_userInformation {

			@Test
			@DisplayName("정상적으로 회원가입 동작을 수행한다.")
			void it_execute_that_register() {

				NewUserRequest request = createNewUserRequest();

				ExtractableResponse<Response> response = 회원_가입_요청(request);

				assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
			}

		}

		private NewUserRequest createNewUserRequest() {
			return new NewUserRequest("mail@mail.com", "steve", "steve123@");
		}
	}

}