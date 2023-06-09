package com.aorri2.goodsforyou.product.application;

import java.util.List;

import com.aorri2.goodsforyou.product.application.command.CreateProductCommand;
import com.aorri2.goodsforyou.product.domain.Product;

public interface ProductManagement {

	void addProduct(CreateProductCommand createProductCommand);

	Product retriveProduct(long productId);

	List<Product> retrieveProducts();
}
