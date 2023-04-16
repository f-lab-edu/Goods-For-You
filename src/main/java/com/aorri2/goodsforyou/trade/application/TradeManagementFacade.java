package com.aorri2.goodsforyou.trade.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aorri2.goodsforyou.trade.application.command.CreateTradeCommand;
import com.aorri2.goodsforyou.trade.domain.TradeCreator;
import com.aorri2.goodsforyou.trade.domain.TradeValidator;

@Service
public class TradeManagementFacade implements TradeManagement {

	private final TradeValidator tradeValidator;
	private final TradeCreator tradeCreator;

	public TradeManagementFacade(TradeValidator tradeValidator,
		TradeCreator tradeCreator) {
		this.tradeValidator = tradeValidator;
		this.tradeCreator = tradeCreator;
	}

	@Override
	@Transactional
	public void registerTrade(CreateTradeCommand createTradeCommand) {
		tradeValidator.checkRegisterValidity(createTradeCommand.toEntity());
		tradeCreator.save(createTradeCommand.toEntity());
	}
}
