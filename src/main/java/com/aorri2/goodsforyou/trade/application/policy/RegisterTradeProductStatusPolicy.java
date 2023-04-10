package com.aorri2.goodsforyou.trade.application.policy;

import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductFinder;
import com.aorri2.goodsforyou.product.domain.ProductStatus;
import com.aorri2.goodsforyou.trade.domain.RegisterTradePolicy;
import com.aorri2.goodsforyou.trade.domain.Trade;
import com.aorri2.goodsforyou.trade.domain.exception.AlreadySoldProductException;

public class RegisterTradeProductStatusPolicy implements RegisterTradePolicy {

	private final ProductFinder productFinder;

	public RegisterTradeProductStatusPolicy(ProductFinder productFinder) {
		this.productFinder = productFinder;
	}

	@Override
	public void apply(Trade trade) {
		Product foundProductById = productFinder.findById(trade.getProductId());
		ProductStatus productStatus = foundProductById.getProductStatus();
		if (!productStatus.isTradable()) {
			throw new AlreadySoldProductException();
		}
	}

}
