package com.aorri2.goodsforyou.trade.presentation.request;

import java.time.LocalDateTime;

import com.aorri2.goodsforyou.trade.application.command.CreateTradeCommand;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

public class CreateTradeRequest {

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
	private LocalDateTime tradeDate;

	@Positive(message = "거래 상품의 수량은 0이상 입니다.")
	private int tradeProductQuantity;

	public CreateTradeRequest() {
	}

	@Builder
	public CreateTradeRequest(Long buyerId, Long sellerId, Long productId, LocalDateTime tradeDate,
		int tradeProductQuantity) {
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.tradeDate = tradeDate;
		this.tradeProductQuantity = tradeProductQuantity;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public Long getProductId() {
		return productId;
	}

	public LocalDateTime getTradeDate() {
		return tradeDate;
	}

	public int getTradeProductQuantity() {
		return tradeProductQuantity;
	}

	public CreateTradeCommand toCommand() {
		return CreateTradeCommand.builder().buyerId(this.buyerId)
			.sellerId(this.sellerId)
			.productId(this.productId)
			.tradeDate(this.tradeDate)
			.tradeProductQuantity(this.tradeProductQuantity)
			.build();
	}

}
