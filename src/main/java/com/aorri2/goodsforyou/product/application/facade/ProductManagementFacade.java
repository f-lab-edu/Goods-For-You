package com.aorri2.goodsforyou.product.application.facade;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void addProduct(CreateProductCommand command) {
		productCreator.save(command.toEntity());
	}

	@Override
	@Transactional(readOnly = true)
	public Product retriveProduct(long productId) {
		Product foundProductThroughId = productFinder.findById(productId);
		productValidator.checkRetriveProductValidity(foundProductThroughId);
		return foundProductThroughId;
	}

	@Override
	@Transactional
	public List<Product> retrieveProducts() {
		return productFinder.findAll();
	}
}
