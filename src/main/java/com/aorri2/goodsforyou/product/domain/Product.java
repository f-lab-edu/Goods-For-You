package com.aorri2.goodsforyou.product.domain;

import java.time.LocalDateTime;

public class Product {

	private String title;

	private int price;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public Product(String title, int price, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.title = title;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
}
