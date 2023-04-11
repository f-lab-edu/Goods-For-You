package com.aorri2.goodsforyou.product.application.policy;

import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductRetrivePolicy;
import com.aorri2.goodsforyou.product.domain.exception.NotExistProductException;

public class ProductRetriveByIdPolicy implements ProductRetrivePolicy {

	@Override
	public void apply(Product foundProduct) {
		if (foundProduct == null) {
			throw new NotExistProductException();
		}
	}
}
