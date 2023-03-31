package com.aorri2.goodsforyou.transaction.domain;

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

@DisplayName("RegisterTransactionProductStatusPolicy 클래스의")
class RegisterTransactionProductStatusPolicyTest {
	@InjectMocks
	RegisterTransactionProductStatusPolicy policy;

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
			void it_throws_exception() {
				Transaction transaction = createTransaction(ProductStatus.SOLD_COMPLETE);

				assertThatThrownBy(() -> policy.apply(transaction)).isInstanceOf(RuntimeException.class);
			}
		}

		@Nested
		@DisplayName("상품의 상태가 '구매가능' 이면")
		class Context_with_product_status_is_available_for_purchase {
			@Test
			@DisplayName("정상적으로 메서드를 수행한다.")
			void it_execute_method_normally() {
				Transaction transaction = createTransaction(ProductStatus.BUY_AVAILABLE);

				assertThatThrownBy(() -> policy.apply(transaction)).isInstanceOf(RuntimeException.class);
			}
		}

		private Transaction createTransaction(ProductStatus productStatus) {
			Transaction transaction = mock(Transaction.class);
			given(transaction.getProductId()).willReturn(1L);
			Product mockProduct = mock(Product.class);
			given(mockProduct.getProductStatus()).willReturn(productStatus);
			given(productFinder.findById(1L)).willReturn(mockProduct);
			return transaction;
		}
	}

}