package com.aorri2.goodsforyou.transaction.application.policy;

import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductFinder;
import com.aorri2.goodsforyou.transaction.domain.RegisterTransactionPolicy;
import com.aorri2.goodsforyou.transaction.domain.Transaction;
import com.aorri2.goodsforyou.transaction.domain.exception.AlreadySoldProductException;

public class RegisterTransactionProductStatusPolicy implements RegisterTransactionPolicy {

	private final ProductFinder productFinder;

	public RegisterTransactionProductStatusPolicy(ProductFinder productFinder) {
		this.productFinder = productFinder;
	}

	@Override
	public void apply(Transaction transaction) {
		Product foundProductById = productFinder.findById(transaction.getProductId());
		String productStatus = foundProductById.getProductStatus().getStatus();
		if (!productStatus.equals("구매 가능")) {
			throw new AlreadySoldProductException();
		}
	}
}
