package com.aorri2.goodsforyou.product.service;

import static com.aorri2.goodsforyou.product.fixture.ProductFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aorri2.goodsforyou.product.application.command.CreateProductCommand;
import com.aorri2.goodsforyou.product.application.facade.ProductManagementFacade;
import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.presentation.request.ProductRequest;

@DisplayName("ProductProductManagement클래스")
@SpringBootTest
class ProductManagementFacadeTest {

	@Autowired
	private ProductManagementFacade productManagementFacade;

	@Nested
	@DisplayName("addProduct 메서드는")
	class Describe_addProduct {
		@Nested
		@DisplayName("유효한 상품 요청 정보가 주어지면")
		class Context_with_valid_product_request_information {
			@Test
			@DisplayName("상품 등록을 정상적으로 수행한다")
			void it_perform_Product_Registration_Normal() {
				ProductRequest request = 상품_요청_정상.상품_요청_생성();

				productManagementFacade.addProduct(request.toCommand());
			}
		}

		@Nested
		@DisplayName("유효하지 않은 상품 요청 정보가 주어지면")
		class Context_with_inValid_product_request_information {
			@Test
			@DisplayName("IllegalArgumentException을 던진다")
			void it_throw_IllegalArgumentException() {
				ProductRequest request = 상품_요청_상품가격_비정상.상품_요청_생성();

				assertThatThrownBy(() -> productManagementFacade.addProduct(request.toCommand()))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("상품 제목은 필수 입력 값 입니다.");
			}
		}
	}

	@Nested
	@DisplayName("retrieveProduct 메서드는")
	class Describe_retrieveProduct {

		@Nested
		@DisplayName("유효한 상품 ID값이 주어진다면")
		class Context_with_valid_product_ID_value {

			@Test
			@DisplayName("상품 ID값에 해당하는 상품 객체를 정상적으로 반환한다.")
			void it_return_correct_product_object() {

				CreateProductCommand 상품요청 = 상품_요청_정상.상품_요청_생성().toCommand();
				productManagementFacade.addProduct(상품요청);

				Product foundProduct = productManagementFacade.retriveProduct(1L);

				assertAll(
					() -> assertThat(foundProduct.getTitle()).isEqualTo("상품1"),
					() -> assertThat(foundProduct.getPrice()).isEqualTo(1000)
				);

			}
		}

		@Nested
		@DisplayName("유효하지 않은 상품 ID값이 주어진다면")
		class Context_with_inValid_product_ID_value {

			@Test
			@DisplayName(" ... ")
			void it_throw_() {

				CreateProductCommand 상품요청 = 상품_요청_정상.상품_요청_생성().toCommand();
				productManagementFacade.addProduct(상품요청);

				Product foundProduct = productManagementFacade.retriveProduct(2L);

				assertAll(
					() -> assertThat(foundProduct.getTitle()).isEqualTo("상품1"),
					() -> assertThat(foundProduct.getPrice()).isEqualTo(1000)
				);

			}
		}
	}
}