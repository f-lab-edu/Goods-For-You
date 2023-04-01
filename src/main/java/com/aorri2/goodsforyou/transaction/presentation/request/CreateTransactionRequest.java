package com.aorri2.goodsforyou.transaction.presentation.request;

import java.time.LocalDateTime;

import com.aorri2.goodsforyou.transaction.application.command.CreateTransactionCommand;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateTransactionRequest {

	@Positive(message = "구매자 ID값은 0보다 커야 합니다.")
	@NotNull(message = "구매자 ID값은 필수 값 입니다.")
	private Long buyerId;
	@Positive(message = "판매자 ID값은 0보다 커야 합니다.")
	@NotNull(message = "판매자 ID값은 필수 값 입니다.")
	private Long sellerId;
	@Positive(message = "상품 ID값은 0보다 커야 합니다.")
	@NotNull(message = "상품 ID값은 필수 값 입니다.")
	private Long productId;

	@FutureOrPresent(message = "거래 날짜는 현재 시간 이후여야 합니다.")
	@NotNull(message = "거래 날짜는 필수 값 입니다.")
	private LocalDateTime transactionDate;

	@Positive(message = "거래 상품의 수량은 0이상 입니다.")
	@NotNull(message = "거래 상품의 수량은 필수 값 입니다.")
	private int transactionProductQuantity;

	public Long getBuyerId() {
		return buyerId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public Long getProductId() {
		return productId;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public int getTransactionProductQuantity() {
		return transactionProductQuantity;
	}

	public CreateTransactionCommand toCommand() {
		return new CreateTransactionCommand(
			this.buyerId,
			this.sellerId,
			this.productId,
			this.transactionDate,
			this.transactionProductQuantity
		);
	}

}
