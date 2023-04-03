package com.aorri2.goodsforyou.trade.application.command;

import java.time.LocalDateTime;

import com.aorri2.goodsforyou.trade.domain.Trade;

public class CreateTradeCommand {
	private Long buyerId;
	private Long sellerId;
	private Long productId;
	private LocalDateTime tradeDate;
	private int tradeProductQuantity;

	public CreateTradeCommand(Long buyerId, Long sellerId, Long productId, LocalDateTime tradeDate,
		int tradeProductQuantity) {
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.tradeDate = tradeDate;
		this.tradeProductQuantity = tradeProductQuantity;
	}

	public Trade toEntity() {
		return new Trade(
			this.buyerId,
			this.sellerId,
			this.productId,
			this.tradeDate,
			this.tradeProductQuantity
		);
	}
}
