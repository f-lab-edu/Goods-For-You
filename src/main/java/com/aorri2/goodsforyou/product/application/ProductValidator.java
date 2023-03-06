package com.aorri2.goodsforyou.product.application;

import com.aorri2.goodsforyou.product.domain.Product;

public interface ProductValidator {
	void checkProductValidity(Product product);
}
