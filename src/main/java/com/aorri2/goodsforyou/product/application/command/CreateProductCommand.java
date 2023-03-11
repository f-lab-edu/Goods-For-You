package com.aorri2.goodsforyou.product.application.command;

import org.springframework.util.Assert;

import com.aorri2.goodsforyou.product.domain.Product;

public class CreateProductCommand {

	private int categoryId;
	private String title;
	private int price;

	public CreateProductCommand(int categoryId, String title, int price) {
		Assert.isTrue(categoryId > 0, "카테고리 아이디는 0 이상 입니다.");
		Assert.hasText(title, "상품 제목은 필수 입력 값 입니다.");
		Assert.isTrue(price > 0, "상품 가격은 0원 이상 입니다.");
		this.categoryId = categoryId;
		this.title = title;
		this.price = price;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public Product toEntity() {
		return new Product(this.categoryId, this.title, this.price);
	}
}
