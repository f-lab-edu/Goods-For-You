package com.aorri2.goodsforyou.product.unit;

import static com.aorri2.goodsforyou.product.domain.ProductStatus.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.product.domain.ProductStatus;

@DisplayName("ProductStatus 클래스")
public class ProductStatusTest {
	@Nested
	@DisplayName("changeStatus메서드는")
	class Describe_changeStatus {

		@Nested
		@DisplayName("현재 ProductStatus가 SOLD_COMPLETE인 상태에서 TRADABLE 상태를 받으면")
		class Context_with_tradable_status_when_current_productstatus_is_SoldComplete {
			@Test
			@DisplayName("soldComplete를 반환한다")
			void it_return_soldComplete() {

				ProductStatus soldComplete = SOLD_COMPLETE;

				ProductStatus changedProductStatus = soldComplete.changeStatus(TRADABLE);

				assertThat(changedProductStatus).isEqualTo(SOLD_COMPLETE);
			}
		}

		@Nested
		@DisplayName("현재 ProductStatus가 SOLD_COMPLETE가 아닌 다른 상태에서 TRADABLE 상태를 받으면")
		class Context_with_tradable_status_when_current_productstatus_is_not_SoldComplete {
			@Test
			@DisplayName("TRADABLE을 반환한다")
			void it_return_tradable() {

				ProductStatus tradable = TRADABLE;
				ProductStatus soldCancelled = SOLD_CANCELED;

				ProductStatus changedProductStatus = tradable.changeStatus(TRADABLE);
				ProductStatus changedProductStatusWithSoldCancelled = soldCancelled.changeStatus(TRADABLE);

				assertThat(changedProductStatus).isEqualTo(TRADABLE);
				assertThat(changedProductStatusWithSoldCancelled).isEqualTo(TRADABLE);
			}
		}

		@Nested
		@DisplayName("현재 ProductStatus가 SOLD_COMPLETE인 상태에서 SOLD_CANCELED 상태를 받으면")
		class Context_with_soldCanceled_status_when_current_productstatus_is_SoldCanceled {
			@Test
			@DisplayName("SOLD_COMPELETE을 반환한다")
			void it_return_SOLD_COMPELETE() {

				ProductStatus soldComplete = SOLD_COMPLETE;

				ProductStatus changedProductStatus = soldComplete.changeStatus(SOLD_CANCELED);

				assertThat(changedProductStatus).isEqualTo(SOLD_COMPLETE);
			}
		}

		@Nested
		@DisplayName("현재 ProductStatus가 SOLD_COMPLETE가 아닌 상태에서 SOLD_CANCELED 상태를 받으면")
		class Context_with_soldCanceled_status_when_current_productstatus_is_not_SoldCanceled {
			@Test
			@DisplayName("SOLD_CANCELED를 반환한다")
			void it_return_SOLD_CANCELED() {

				assertThat(SOLD_CANCELED.changeStatus(SOLD_CANCELED)).isEqualTo(SOLD_CANCELED);
				assertThat(TRADABLE.changeStatus(SOLD_CANCELED)).isEqualTo(SOLD_CANCELED);
			}
		}

		@Nested
		@DisplayName("SOLD_COMPLETE 상태를 받으면")
		class Context_with_productStatus_is_soldComplete {
			@Test
			@DisplayName("SOLD_COMPLETE를 반환한다")
			void it_return_SOLD_COMPLETE() {

				assertThat(SOLD_CANCELED.changeStatus(SOLD_COMPLETE)).isEqualTo(SOLD_COMPLETE);
				assertThat(TRADABLE.changeStatus(SOLD_COMPLETE)).isEqualTo(SOLD_COMPLETE);
			}
		}

		@Nested
		@DisplayName("존재하지 않는 상품 상태를 받으면")
		class Context_with_inValid_productStatus {
			@Test
			@DisplayName("예외를 던진다")
			void it_throws_IllegalArgumentException() {

				assertThatThrownBy(
					() -> SOLD_CANCELED.changeStatus(ProductStatus.valueOf("INVALID_STATUS"))).isInstanceOf(
					IllegalArgumentException.class);
			}
		}
	}
}
