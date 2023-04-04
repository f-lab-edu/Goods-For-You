package com.aorri2.goodsforyou.product.domain;

public enum ProductStatus {
	TRADABLE("구매 가능"),
	SOLD_COMPLETE("판매 완료"),
	;
	private final String status;

	ProductStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public static ProductStatus getInitValue() {
		return TRADABLE;
	}

	public boolean isTradable() {
		return this.equals(TRADABLE);
	}
}
