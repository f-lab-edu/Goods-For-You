package com.aorri2.goodsforyou.product.unit;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aorri2.goodsforyou.product.application.facade.ProductManagementFacade;
import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductFinder;

@DisplayName("ProductManagementFacade 클래스")
@ExtendWith(MockitoExtension.class)
public class ProductManagementFacadeTest {

	@Mock
	ProductFinder productFinder;

	@InjectMocks
	ProductManagementFacade sut;

	@Nested
	@DisplayName("retrieveProducts 메서드는")
	class Describe_retrieveProducts {

		@Nested
		@DisplayName("상품 목록 정보가 존재한다면")
		class Context_with_product_list {
			@Test
			@DisplayName("상품 목록을 반환한다")
			void it_returns_product_list() {

				List<Product> expectedProducts = IntStream.range(1, 11).mapToObj(i -> mock(Product.class)).toList();

				given(productFinder.findAll(null)).willReturn(expectedProducts);

				List<Product> products = sut.retrieveProducts(null);

				assertThat(products).hasSameSizeAs(expectedProducts);
			}
		}
	}
}
