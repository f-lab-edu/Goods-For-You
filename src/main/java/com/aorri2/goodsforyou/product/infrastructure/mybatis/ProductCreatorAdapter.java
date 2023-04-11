package com.aorri2.goodsforyou.product.infrastructure.mybatis;

import org.springframework.stereotype.Repository;

import com.aorri2.goodsforyou.common.annotation.ElapsedTime;
import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.product.domain.ProductCreator;

@Repository
@ElapsedTime
public class ProductCreatorAdapter implements ProductCreator {

	private final MybatisProductMapper mapper;

	public ProductCreatorAdapter(MybatisProductMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void save(Product product) {
		mapper.save(product);
	}
}
