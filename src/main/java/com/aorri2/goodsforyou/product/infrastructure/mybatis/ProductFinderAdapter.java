package com.aorri2.goodsforyou.product.infrastructure.mybatis;

import org.springframework.stereotype.Repository;

import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductFinder;

@Repository
public class ProductFinderAdapter implements ProductFinder {
	private final MybatisProductMapper mapper;

	public ProductFinderAdapter(MybatisProductMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Product findById(long productId) {
		return mapper.findById(productId);
	}
}
