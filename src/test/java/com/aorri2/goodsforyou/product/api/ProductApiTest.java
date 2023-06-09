package com.aorri2.goodsforyou.product.api;

import static com.aorri2.goodsforyou.consts.ApiPathConstant.*;
import static com.aorri2.goodsforyou.consts.SessionConst.*;
import static com.aorri2.goodsforyou.product.api.ProductSteps.*;
import static com.aorri2.goodsforyou.product.fixture.ProductFixture.*;
import static com.aorri2.goodsforyou.user.UserSteps.*;
import static com.aorri2.goodsforyou.utils.LoginRequestUtil.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.aorri2.goodsforyou.ApiTest;
import com.aorri2.goodsforyou.product.presentation.request.ProductRequest;
import com.aorri2.goodsforyou.utils.DefaultSessionConfig;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@DisplayName("ProductApiTest 클래스")
@Import(DefaultSessionConfig.class)
public class ProductApiTest extends ApiTest {

	@Nested
	@DisplayName("상품 등록 API는")
	class Describe_Product_Register_API {

		@Nested
		@DisplayName("인증이 완료되었고,정상적인 상품 정보가 주어진다면")
		class Context_with_authorized_user_normal_product_information {
			@Test
			@DisplayName("정상적으로 상품 등록을 진행하고 상태코드 201을 반환한다.")
			@Order(1)
			void it_return_status_code_201() {

				로그인_완료_상태_생성();

				ProductRequest productRequest = 상품_요청_정상.상품_요청_생성();
				ExtractableResponse<Response> response = 상품_생성_요청(productRequest);

				assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
			}
		}

		@Nested
		@DisplayName("값이 비정상적인 상품 정보가 주어진다면")
		class Context_with_abnormal_product_information {
			@ParameterizedTest(name = "#{index} - {displayName}")
			@DisplayName("상품 등록 과정이 비정상적으로 종료되고, 상태코드 400을 반환한다.")
			@MethodSource("상품_요청_비정상_목록_생성")
			@Order(2)
			void it_ended_abnormal_and_returned_statuscode_400() {
				로그인_완료_상태_생성();

				ProductRequest productRequest = 상품_요청_아이디값_비정상.상품_요청_생성();
				ExtractableResponse<Response> response = 상품_생성_요청(productRequest);

				assertSoftly(softAssertions -> {
					assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
					assertThat(response.jsonPath().getString("code")).isEqualTo("USER-001");
				});
			}

			static Stream<Arguments> 상품_요청_비정상_목록_생성() {
				return Stream.of(
					Arguments.of(상품_요청_아이디값_비정상),
					Arguments.of(상품_요청_아이디값_비정상),
					Arguments.of(상품_요청_상품가격_비정상)
				);
			}
		}

	}

	@Nested
	@DisplayName("상품 목록 조회 API는")
	class Describe_product_retrieve_api {

		@Nested
		@DisplayName("인증이 완료되었고, 상품 목록을 조회한다면")
		class Context_with_authorized_user_and_retrieve_product_list {
			@Test
			@DisplayName("상품 목록을 반환한다")
			void it_return_product_list() {
				로그인_완료_상태_생성();

				ExtractableResponse<Response> response = RestAssured.given().log().all()
					.cookie(SESSION, 로그인_성공_세션_아이디())
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.when()
					.get(PRODUCT_API_PATH)
					.then()
					.log().all().extract();

				assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
				assertThat(response.jsonPath().getString("resultCode")).isEqualTo("SUCCESS");
				assertThat(response.jsonPath().getString("result")).isNotNull();
			}
		}

		@Nested
		@DisplayName("인증하지 않은 상태에서, 상품 목록을 조회한다면")
		class Context_with_unAuthorized_user_and_retrieve_product_list {
			@Test
			@DisplayName("401 status code를 반환한다")
			void it_return_401_status_code() {

				ExtractableResponse<Response> response = RestAssured.given().log().all()
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.when()
					.get(PRODUCT_API_PATH)
					.then()
					.log().all().extract();

				assertThat(response.statusCode()).isEqualTo(HttpStatus.UNAUTHORIZED.value());
			}
		}
	}

}
