package com.aorri2.goodsforyou.user;

import org.springframework.http.MediaType;

import com.aorri2.goodsforyou.user.presentation.request.LoginUserRequest;
import com.aorri2.goodsforyou.user.presentation.request.NewUserRequest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class UserSteps {
	private static final String LOGIN_USER_URL = "/api/v1/login";
	private static final String REGISTER_USER_URL = "/api/v1/users";

	public static ExtractableResponse<Response> 회원_가입_요청(NewUserRequest request) {
		return RestAssured.given().log().all()      //given().log().all()은 요청을 남기는 로그를 모두 남긴다는 의미입니다.
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(request)
			.when()
			.post(REGISTER_USER_URL)
			.then()
			.log().all().extract();
	}

	public static ExtractableResponse<Response> 로그인_요청(LoginUserRequest loginUserRequest) {

		return RestAssured.given().log().all()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(loginUserRequest)
			.when()
			.post(LOGIN_USER_URL)
			.then()
			.log().all().extract();
	}
}
