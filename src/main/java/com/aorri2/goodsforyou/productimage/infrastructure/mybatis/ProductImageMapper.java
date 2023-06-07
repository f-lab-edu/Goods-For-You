package com.aorri2.goodsforyou.productimage.infrastructure.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aorri2.goodsforyou.productimage.domain.ProductImage;

@Mapper
public interface ProductImageMapper {

	void saveAll(List<ProductImage> image);
}
