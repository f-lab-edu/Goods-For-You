package com.aorri2.goodsforyou.trade.api;

import static com.aorri2.goodsforyou.trade.fixture.TradeFixture.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.aorri2.goodsforyou.ApiTest;
import com.aorri2.goodsforyou.trade.TradeSteps;
import com.aorri2.goodsforyou.trade.presentation.request.CreateTradeRequest;
import com.aorri2.goodsforyou.utils.LoginRequestUtil;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@DisplayName("TradeApiTest 클래스")
public class TradeAPiTest extends ApiTest {

	@Nested
	@DisplayName("거래 등록 Api는")
	class Describe_trade_register_api {

		@Nested
		@DisplayName("정상적인 거래 정보가 주어진다면")
		class Context_with_valid_trade_information {
			@Test
			@DisplayName("정상적으로 거래를 등록하고, 상태코드 201을 반환한다")
			void it_execute_normally_and_return_status_code_201() {
				//given
				LoginRequestUtil.로그인_완료_상태_생성();
				CreateTradeRequest tradeRequest = 거래_요청_정상.거래_요청_생성();

				//when
				ExtractableResponse<Response> response = TradeSteps.거래_요청(tradeRequest);

				//then
				assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
			}
		}

		@Nested
		@DisplayName("정상적이지 않은 거래 정보가 주어진다면")
		class Context_with_invalid_trade_information {
			@Test
			@DisplayName("거래등록에 실패하고, 상태코드 400을 반환한다")
			void it_execute_normally_and_return_status_code_400() {
				//given
				LoginRequestUtil.로그인_완료_상태_생성();
				CreateTradeRequest tradeRequest = 거래_요청_상품상태_비정상.거래_요청_생성();

				//when
				ExtractableResponse<Response> response = TradeSteps.거래_요청(tradeRequest);

				//then
				assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
			}
		}
	}

}
