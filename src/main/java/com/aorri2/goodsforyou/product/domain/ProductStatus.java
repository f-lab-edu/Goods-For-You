package com.aorri2.goodsforyou.product.domain;

public enum ProductStatus {
	BUY_AVAILABLE("구매 가능"),
	SOLD_COMPLETE("판매 완료"),
	;
	private final String status;

	ProductStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
