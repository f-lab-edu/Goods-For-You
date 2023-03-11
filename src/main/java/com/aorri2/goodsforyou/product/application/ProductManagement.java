package com.aorri2.goodsforyou.product.application;

import com.aorri2.goodsforyou.product.application.command.CreateProductCommand;

public interface ProductManagement {

	void addProduct(CreateProductCommand Product);

}
