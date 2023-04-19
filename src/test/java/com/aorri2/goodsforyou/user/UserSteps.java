package com.aorri2.goodsforyou.user;

import static com.aorri2.goodsforyou.consts.ApiPathConstant.*;
import static com.aorri2.goodsforyou.consts.SessionConst.*;
import static com.aorri2.goodsforyou.user.fixture.LoginUserFixture.*;
import static com.aorri2.goodsforyou.user.fixture.NewUserFixture.*;

import org.springframework.http.MediaType;

import com.aorri2.goodsforyou.user.presentation.request.LoginUserRequest;
import com.aorri2.goodsforyou.user.presentation.request.NewUserRequest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class UserSteps {

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

	public static String 로그인_성공_세션_아이디() {
		ExtractableResponse<Response> response = 로그인_요청(로그인_유저_요청_정상.로그인_유저_요청_생성());
		String session = response.cookie(SESSION);
		return session;
	}

	public static void 회원_가입_요청_정상_생성() {
		UserSteps.회원_가입_요청(회원가입_요청_정상.회원가입_요청_생성());
	}

	public static void 로그인_유저_정상_생성() {
		LoginUserRequest loginUserRequest = 로그인_유저_요청_정상.로그인_유저_요청_생성();
		로그인_요청(loginUserRequest);
	}
}
