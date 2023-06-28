package com.aorri2.goodsforyou.product.api;

import static com.aorri2.goodsforyou.consts.ApiPathConstant.*;
import static com.aorri2.goodsforyou.consts.SessionConst.*;
import static com.aorri2.goodsforyou.user.UserSteps.*;

import org.springframework.http.MediaType;

import com.aorri2.goodsforyou.product.presentation.request.ProductRequest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class ProductSteps {

	public static ExtractableResponse<Response> 상품_생성_요청(ProductRequest productRequest) {

		return RestAssured.given().log().all()
			.cookie(SESSION, 로그인_성공_세션_아이디())
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(productRequest)
			.when()
			.post(PRODUCT_API_PATH)
			.then()
			.log().all().extract();
	}
}
