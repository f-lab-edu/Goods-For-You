package com.aorri2.goodsforyou.transaction.infrastructure.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.aorri2.goodsforyou.transaction.domain.Transaction;

@Mapper
public interface MybatisTransactionMapper {

	@Insert("insert into TRADE (buyer_id, seller_id, product_id,transaction_date,transaction_status,transaction_product_quantity) VALUES (#{buyerId}, #{sellerId}, #{productId}, #{transactionDate},#{transactionStatus}, #{transactionProductQuantity})")
	void save(Transaction transaction);
}
