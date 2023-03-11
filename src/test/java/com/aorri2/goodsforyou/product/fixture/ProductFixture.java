package com.aorri2.goodsforyou.product.fixture;

import com.aorri2.goodsforyou.product.presentation.request.ProductRequest;

public enum ProductFixture {

	//--정상 요청--
	상품_요청_정상(1, "상품1", 1000),

	//--비정상 값--
	상품_요청_아이디값_비정상(0, "상품2", 2000),
	상품_요청_상품이름_비정상(1, " ", 2000),
	상품_요청_상품가격_비정상(1, " ", -1000);

	private final int categoryId;
	private final String title;
	private final int price;

	ProductFixture(int categoryId, String title, int price) {
		this.categoryId = categoryId;
		this.title = title;
		this.price = price;
	}

	public int 카테고리ID() {
		return categoryId;
	}

	public String 타이틀() {
		return title;
	}

	public int 가격() {
		return price;
	}

	public ProductRequest 상품_요청_생성() {
		return new ProductRequest(카테고리ID(), 타이틀(), 가격());
	}
}
