package com.aorri2.goodsforyou.product.domain;

import java.time.LocalDateTime;

public class Product {

	private long id;

	private int categoryId;

	private String title;

	private int price;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	protected Product() {
	}

	public Product(int categoryId, String title, int price) {
		this.categoryId = categoryId;
		this.title = title;
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public long getId() {
		return id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
