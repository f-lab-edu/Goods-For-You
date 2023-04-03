package com.aorri2.goodsforyou.trade.infrastructure.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.aorri2.goodsforyou.trade.domain.Trade;

@Mapper
public interface MybatisTradeMapper {

	@Insert("insert into TRADE (buyer_id, seller_id, product_id,trade_date,trade_status,trade_product_quantity) VALUES (#{buyerId}, #{sellerId}, #{productId}, #{tradeDate},#{tradeStatus}, #{tradeProductQuantity})")
	void save(Trade trade);
}
