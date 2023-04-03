package com.aorri2.goodsforyou.trade.infrastructure.mybatis;

import org.springframework.stereotype.Repository;

import com.aorri2.goodsforyou.trade.domain.Trade;
import com.aorri2.goodsforyou.trade.domain.TradeCreator;

@Repository
public class TradeCreatorAdapter implements TradeCreator {

	private final MybatisTradeMapper mapper;

	public TradeCreatorAdapter(MybatisTradeMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void save(Trade trade) {
		mapper.save(trade);
	}
}
