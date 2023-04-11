package com.aorri2.goodsforyou.product.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductRetrivePolicy;
import com.aorri2.goodsforyou.product.domain.ProductValidator;

@Component
public class DefaultProductValidator implements ProductValidator {

	private final List<ProductRetrivePolicy> productRetrivePolicyList;

	public DefaultProductValidator(List<ProductRetrivePolicy> productRetrivePolicyList) {
		this.productRetrivePolicyList = productRetrivePolicyList;
	}

	@Override
	public void checkRetriveProductValidity(Product foundProductThroughId) {
		productRetrivePolicyList.forEach(policy -> policy.apply(foundProductThroughId));
	}
}
