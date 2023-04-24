package com.aorri2.goodsforyou.trade;

import static com.aorri2.goodsforyou.consts.ApiPathConstant.*;
import static com.aorri2.goodsforyou.consts.SessionConst.*;
import static com.aorri2.goodsforyou.user.UserSteps.*;
import static io.restassured.RestAssured.*;

import org.springframework.http.MediaType;

import com.aorri2.goodsforyou.trade.presentation.request.CreateTradeRequest;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class TradeSteps {

	public static ExtractableResponse<Response> 거래_요청(CreateTradeRequest tradeRequest) {
		ExtractableResponse<Response> response = given().log().all()
			.cookie(SESSION, 로그인_성공_세션_아이디())
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(tradeRequest)
			.when()
			.post(ADD_TRADE_PATH)
			.then()
			.log().all().extract();
		return response;
	}
}
