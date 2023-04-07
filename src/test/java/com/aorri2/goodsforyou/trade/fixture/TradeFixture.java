package com.aorri2.goodsforyou.trade.fixture;

import java.time.LocalDateTime;

import com.aorri2.goodsforyou.trade.presentation.request.CreateTradeRequest;

public enum TradeFixture {

	//-- 정상 요청
	거래_요청_정상(1L, 2L, 1L, LocalDateTime.now().plusDays(1L), 10),
	거래_요청_상품상태_비정상(1L, 2L, 2L, LocalDateTime.now().plusDays(1L), 10),
	;

	private final Long buyerId;
	private final Long sellerId;
	private final Long productId;
	private final LocalDateTime tradeDate;
	private final int tradeProductQuantity;

	TradeFixture(Long buyerId, Long sellerId, Long productId, LocalDateTime tradeDate, int tradeProductQuantity) {
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.tradeDate = tradeDate;
		this.tradeProductQuantity = tradeProductQuantity;
	}

	public Long 구매자ID() {
		return buyerId;
	}

	public Long 판매자ID() {
		return sellerId;
	}

	public Long 거래상품ID() {
		return productId;
	}

	public LocalDateTime 거래일자() {
		return tradeDate;
	}

	public int 거래상품수량() {
		return tradeProductQuantity;
	}

	public CreateTradeRequest 거래_요청_생성() {
		return new CreateTradeRequest(구매자ID(), 판매자ID(), 거래상품ID(), 거래일자(), 거래상품수량());
	}
}
