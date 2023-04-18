package com.aorri2.goodsforyou.product.api;

import static com.aorri2.goodsforyou.product.api.ProductSteps.*;
import static com.aorri2.goodsforyou.product.fixture.ProductFixture.*;
import static com.aorri2.goodsforyou.user.UserSteps.*;
import static com.aorri2.goodsforyou.user.fixture.LoginUserFixture.*;
import static com.aorri2.goodsforyou.user.fixture.NewUserFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.HttpStatus;

import com.aorri2.goodsforyou.ApiTest;
import com.aorri2.goodsforyou.product.presentation.request.ProductRequest;
import com.aorri2.goodsforyou.user.UserSteps;
import com.aorri2.goodsforyou.user.presentation.request.LoginUserRequest;
import com.aorri2.goodsforyou.user.presentation.request.NewUserRequest;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@DisplayName("ProductApiTest 클래스")
@Disabled
public class ProductApiTest extends ApiTest {

	static final String ADD_PRODUCT_PATH = "/api/v1/products";

	@Nested
	@DisplayName("상품 등록 API는")
	class Describe_Product_Register_API {

		@Nested
		@DisplayName("인증이 완료되었고,정상적인 상품 정보가 주어진다면")
		class Context_with_authorized_user_normal_product_information {
			@Test
			@DisplayName("정상적으로 상품 등록을 진행하고 상태코드 201을 반환한다.")
			void it_return_status_code_201() {

				// makeAuthenticateUser();

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
			void it_ended_abnormal_and_returned_statuscode_400() {
				makeAuthenticateUser();

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

	private static void makeAuthenticateUser() {
		NewUserRequest userRequest = 회원가입_요청_정상.회원가입_요청_생성();
		UserSteps.회원_가입_요청(userRequest);

		LoginUserRequest loginUserRequest = 로그인_유저_요청_정상.로그인_유저_요청_생성();
		로그인_요청(loginUserRequest);
	}

}
