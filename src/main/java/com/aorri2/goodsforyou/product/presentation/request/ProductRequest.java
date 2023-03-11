package com.aorri2.goodsforyou.product.presentation.request;

import org.hibernate.validator.constraints.Range;

import com.aorri2.goodsforyou.product.application.command.CreateProductCommand;

import jakarta.validation.constraints.NotBlank;

public class ProductRequest {

	@Range(min = 1, message = "카테고리 ID는 최소 1이상 입니다.")
	private int categoryId;
	@NotBlank(message = "상품 이름을 입력해주세요")
	private String title;
	@Range(min = 0, message = "상품 가격은 최소 0원 이상입니다.")
	private int price;

	public ProductRequest(int categoryId, String title, int price) {
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

	public CreateProductCommand toCommand() {
		return new CreateProductCommand(this.categoryId, this.title, this.price);
	}
}
