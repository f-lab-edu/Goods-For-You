package com.aorri2.goodsforyou.transaction.domain;

import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductFinder;

public class RegisterTransactionProductStatusPolicy implements RegisterTransactionPolicy {

	private ProductFinder productFinder;

	@Override
	public void apply(Transaction transaction) {
		Product foundProductById = productFinder.findById(transaction.getProductId());
		String productStatus = foundProductById.getProductStatus().toString();
		if (!productStatus.equals("구매 가능")) {
			throw new RuntimeException("이미 판매 완료된 상품 입니다.");
		}
	}
}
