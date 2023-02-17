package com.aorri2.goodsforyou.user;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.aorri2.goodsforyou.user.presentation.request.NewUserRequest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

/**
 * webEnvironment 속성은 테스트의 웹 환경을 설정하는 속성입니다. 기본값은 WebEnvironment.MOCK입니다.
 * RANDOM_PORT로 설정하면 스프링 부트의 내장 서버를 랜덤 포트로 설정합니다.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("UserIntegrationTest 클래스")
@Disabled
class UserIntegrationTest {

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}

	@Nested
	@DisplayName("register 메서드는")
	class Describe_register {

		@Nested
		@DisplayName("유저정보가 주어진다면")
		class Context_with_userInformation {

			@Test
			@DisplayName("정상적으로 회원가입 동작을 수행한다.")
			void it_execute_that_register() {

				String url = "/api/v1/users";
				NewUserRequest request = createNewUserRequest();

				/**
				 * given().log().all()은 요청을 남기는 로그를 모두 남긴다는 의미입니다.
				 */
				ExtractableResponse<Response> response = RestAssured.given().log().all()
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.body(request)
					.when()
					.post(url)
					.then()
					.log().all().extract();

				assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
			}

		}

		private NewUserRequest createNewUserRequest() {
			return new NewUserRequest("mail@mail.com", "steve", "steve123@");
		}
	}

}