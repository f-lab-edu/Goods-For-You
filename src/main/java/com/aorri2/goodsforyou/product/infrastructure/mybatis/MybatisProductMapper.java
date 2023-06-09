package com.aorri2.goodsforyou.product.infrastructure.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.aorri2.goodsforyou.product.domain.Product;

@Mapper
public interface MybatisProductMapper {

	@Insert("insert into PRODUCT (category_id,title,price,product_status) values (#{categoryId},#{title},#{price},#{productStatus})")
	void save(Product product);

	@Select("select * from PRODUCT where id = #{productId}")
	Product findById(long productId);

	// TODO : noOffSet 쿼리 적용에 따른 추가 수정 필요
	@Select("select * from PRODUCT ORDER BY created_at LIMIT 10")
	List<Product> findAll();
}
