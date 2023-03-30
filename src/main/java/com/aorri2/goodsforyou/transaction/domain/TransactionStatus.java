package com.aorri2.goodsforyou.transaction.domain;

public enum TransactionStatus {
	BEFORE_TRANSACTION("거래 전"),
	TRANSACTION_IN_PROGRESS("거래 진행 중"),
	TRANSACTION_COMPLETE("거래 완료"),
	;

	private final String status;

	TransactionStatus(String status) {
		this.status = status;
	}
}
