package com.aorri2.goodsforyou.product.application;

import com.aorri2.goodsforyou.product.application.command.CreateProductCommand;
import com.aorri2.goodsforyou.product.domain.Product;

public interface ProductManagement {

	void addProduct(CreateProductCommand Product);

	Product retriveProduct(long productId);
}
