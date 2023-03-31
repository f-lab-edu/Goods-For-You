package com.aorri2.goodsforyou.transaction.domain;

import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductFinder;
import com.aorri2.goodsforyou.transaction.domain.exception.UnAvailableProductException;

public class RegisterTransactionProductStatusPolicy implements RegisterTransactionPolicy {

	private ProductFinder productFinder;

	@Override
	public void apply(Transaction transaction) {
		Product foundProductById = productFinder.findById(transaction.getProductId());
		String productStatus = foundProductById.getProductStatus().getStatus();
		if (!productStatus.equals("구매 가능")) {
			throw new UnAvailableProductException();
		}
	}
}
