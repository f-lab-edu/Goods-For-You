package com.aorri2.goodsforyou.productimage.infrastructure.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aorri2.goodsforyou.common.annotation.ElapsedTime;
import com.aorri2.goodsforyou.productimage.domain.ProductImage;
import com.aorri2.goodsforyou.productimage.domain.ProductImageCreator;

@Repository
@ElapsedTime
public class ProductImageCreatorAdapter implements ProductImageCreator {

	private final ProductImageMapper mapper;

	public ProductImageCreatorAdapter(ProductImageMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void saveAll(List<ProductImage> images) {
		mapper.saveAll(images);
	}
}
