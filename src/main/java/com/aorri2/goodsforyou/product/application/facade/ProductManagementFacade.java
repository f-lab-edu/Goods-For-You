package com.aorri2.goodsforyou.product.application.facade;

import org.springframework.stereotype.Service;

import com.aorri2.goodsforyou.product.application.ProductManagement;
import com.aorri2.goodsforyou.product.application.command.CreateProductCommand;
import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductCreator;
import com.aorri2.goodsforyou.product.domain.ProductFinder;
import com.aorri2.goodsforyou.product.domain.ProductValidator;

@Service
public class ProductManagementFacade implements ProductManagement {
	private final ProductCreator productCreator;
	private final ProductFinder productFinder;
	private final ProductValidator productValidator;

	public ProductManagementFacade(ProductCreator productCreator, ProductFinder productFinder,
		ProductValidator productValidator) {
		this.productCreator = productCreator;
		this.productFinder = productFinder;
		this.productValidator = productValidator;
	}

	@Override
	public void addProduct(CreateProductCommand command) {
		productCreator.save(command.toEntity());
	}

	@Override
	public Product retriveProduct(long productId) {
		Product foundProductThroughId = productFinder.findById(productId);
		productValidator.checkRetriveProductValidity(foundProductThroughId);
		return foundProductThroughId;
	}
}
