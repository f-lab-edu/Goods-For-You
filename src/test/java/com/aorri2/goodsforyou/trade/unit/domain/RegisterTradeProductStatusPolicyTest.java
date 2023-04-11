package com.aorri2.goodsforyou.trade.unit.domain;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductFinder;
import com.aorri2.goodsforyou.product.domain.ProductStatus;
import com.aorri2.goodsforyou.trade.application.policy.RegisterTradeProductStatusPolicy;
import com.aorri2.goodsforyou.trade.domain.Trade;
import com.aorri2.goodsforyou.trade.domain.exception.AlreadySoldProductException;

@DisplayName("RegisterTradeProductStatusPolicy 클래스의")
class RegisterTradeProductStatusPolicyTest {
	@InjectMocks
	RegisterTradeProductStatusPolicy policy;

	@Mock
	ProductFinder productFinder;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Nested
	@DisplayName("apply 메소드는")
	class Describe_apply {

		@Nested
		@DisplayName("상품의 상태가 '구매가능'이 아니면")
		class Context_with_product_status_is_not_available_for_purchase {
			@Test
			@DisplayName("exception을 던진다.")
			void it_throws_AlreadySoldProductException() {
				Trade trade = createTrade(ProductStatus.SOLD_COMPLETE);

				assertThatThrownBy(() -> policy.apply(trade)).isInstanceOf(AlreadySoldProductException.class);
			}
		}

		@Nested
		@DisplayName("상품의 상태가 '구매가능' 이면")
		class Context_with_product_status_is_available_for_purchase {
			@Test
			@DisplayName("정상적으로 메서드를 수행한다.")
			void it_execute_method_normally() {
				Trade trade = createTrade(ProductStatus.getInitValue());

				policy.apply(trade);
			}
		}

		private Trade createTrade(ProductStatus productStatus) {
			Trade trade = mock(Trade.class);
			given(trade.getProductId()).willReturn(1L);
			Product mockProduct = mock(Product.class);
			given(mockProduct.getProductStatus()).willReturn(productStatus);
			given(productFinder.findById(1L)).willReturn(mockProduct);
			return trade;
		}
	}

}