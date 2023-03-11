package com.aorri2.goodsforyou.product.application.facade;

import org.springframework.stereotype.Service;

import com.aorri2.goodsforyou.product.application.command.CreateProductCommand;
import com.aorri2.goodsforyou.product.domain.ProductCreator;

@Service
public class ProductManagementFacade implements com.aorri2.goodsforyou.product.application.ProductManagement {
	private final ProductCreator productCreator;

	public ProductManagementFacade(ProductCreator productCreator) {
		this.productCreator = productCreator;
	}

	@Override
	public void addProduct(CreateProductCommand command) {
		productCreator.save(command.toEntity());
	}
}
