package com.aorri2.goodsforyou.trade.application;

import com.aorri2.goodsforyou.trade.application.command.CreateTradeCommand;

public interface TradeManagement {
	void registerTrade(CreateTradeCommand createTradeCommand);
}
