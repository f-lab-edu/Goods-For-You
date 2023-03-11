package com.aorri2.goodsforyou.user;

import org.springframework.http.MediaType;

import com.aorri2.goodsforyou.user.presentation.request.NewUserRequest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class UserSteps {
	public static ExtractableResponse<Response> 회원_가입_요청(String url, NewUserRequest request) {
		return RestAssured.given().log().all()      //given().log().all()은 요청을 남기는 로그를 모두 남긴다는 의미입니다.
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(request)
			.when()
			.post(url)
			.then()
			.log().all().extract();
	}
}
