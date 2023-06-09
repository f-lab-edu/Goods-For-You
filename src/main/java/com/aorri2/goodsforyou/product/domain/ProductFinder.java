package com.aorri2.goodsforyou.product.domain;

import java.util.List;

public interface ProductFinder {
	Product findById(long productId);

	List<Product> findAll();
}
