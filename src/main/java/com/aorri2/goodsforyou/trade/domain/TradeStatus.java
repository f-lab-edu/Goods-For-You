package com.aorri2.goodsforyou.trade.domain;

public enum TradeStatus {
	BEFORE_TRADE("거래 전"),
	TRADE_IN_PROGRESS("거래 진행 중"),
	TRADE_COMPLETE("거래 완료"),
	;

	private final String status;

	TradeStatus(String status) {
		this.status = status;
	}
}
