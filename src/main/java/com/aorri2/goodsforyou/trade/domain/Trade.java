package com.aorri2.goodsforyou.trade.domain;

import java.time.LocalDateTime;

import lombok.Builder;

public class Trade {

	private Long id;
	private Long buyerId;
	private Long sellerId;
	private Long productId;
	private LocalDateTime tradeDate;
	private TradeStatus tradeStatus;
	private int tradeProductQuantity;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	protected Trade() {
	}

	@Builder
	public Trade(Long buyerId, Long sellerId, Long productId, LocalDateTime tradeDate,
		int tradeProductQuantity) {
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.tradeDate = tradeDate;
		this.tradeStatus = TradeStatus.BEFORE_TRADE;
		this.tradeProductQuantity = tradeProductQuantity;
	}

	public Long getProductId() {
		return productId;
	}
}
