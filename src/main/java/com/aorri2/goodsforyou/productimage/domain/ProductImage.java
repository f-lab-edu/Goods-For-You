package com.aorri2.goodsforyou.productimage.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductImage {
	private long id;
	private long productId;
	private String name;
	private String url;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	protected ProductImage() {
	}

	@Builder
	public ProductImage(
		long productId,
		String name,
		String url,
		LocalDateTime createdAt,
		LocalDateTime updatedAt) {
		this.productId = productId;
		this.name = name;
		this.url = url;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
