package com.aorri2.goodsforyou.product.infrastructure.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aorri2.goodsforyou.common.annotation.ElapsedTime;
import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductFinder;

@Repository
@ElapsedTime
public class ProductFinderAdapter implements ProductFinder {
	private final MybatisProductMapper mapper;

	public ProductFinderAdapter(MybatisProductMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Product findById(long productId) {
		return mapper.findById(productId);
	}

	@Override
	public List<Product> findAll(Long productId) {
		return mapper.findAll(productId);
	}
}
