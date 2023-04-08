package com.aorri2.goodsforyou.product.domain;

public enum ProductStatus {
	TRADABLE("구매 가능"),
	SOLD_COMPLETE("판매 완료"),
	SOLD_CANCELED("판매 취소"),
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

	public boolean isSoldComplete() {
		return this.equals(SOLD_COMPLETE);
	}

	public ProductStatus changeStatus(ProductStatus status) {
		switch (status) {
			case TRADABLE -> {
				if (isSoldComplete()) {
					return SOLD_COMPLETE;
				} else {
					return TRADABLE;
				}
			}

			case SOLD_CANCELED -> {
				if (isSoldComplete()) {
					return SOLD_COMPLETE;
				} else {
					return SOLD_CANCELED;
				}
			}

			case SOLD_COMPLETE -> {
				return SOLD_COMPLETE;
			}
			default -> throw new IllegalArgumentException("유효하지 않은 status입니다.");
		}
	}

}
