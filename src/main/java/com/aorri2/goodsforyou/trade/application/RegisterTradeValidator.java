package com.aorri2.goodsforyou.trade.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.trade.domain.RegisterTradePolicy;
import com.aorri2.goodsforyou.trade.domain.Trade;
import com.aorri2.goodsforyou.trade.domain.TradeValidator;

@Component
public class RegisterTradeValidator implements TradeValidator {

	private final List<RegisterTradePolicy> registerTradePolicyList;

	public RegisterTradeValidator(List<RegisterTradePolicy> registerTradePolicyList) {
		this.registerTradePolicyList = registerTradePolicyList;
	}

	@Override
	public void checkRegisterValidity(Trade trade) {
		registerTradePolicyList.forEach(policy -> policy.apply(trade));
	}
}
