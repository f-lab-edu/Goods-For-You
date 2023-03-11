package com.aorri2.goodsforyou.product.infrastructure.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.aorri2.goodsforyou.product.domain.Product;

@Mapper
public interface MybatisProductMapper {

	@Insert("insert into PRODUCT (category_id,title,price) values (#{categoryId},#{title},#{price})")
	void save(Product product);
}
