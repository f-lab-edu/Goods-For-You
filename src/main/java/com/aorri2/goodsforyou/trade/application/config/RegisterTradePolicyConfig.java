package com.aorri2.goodsforyou.trade.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aorri2.goodsforyou.product.domain.ProductFinder;
import com.aorri2.goodsforyou.trade.application.policy.RegisterTradeProductStatusPolicy;

@Configuration
public class RegisterTradePolicyConfig {

	@Bean
	public RegisterTradeProductStatusPolicy registerTradeProductStatusPolicy(ProductFinder productFinder) {
		return new RegisterTradeProductStatusPolicy(productFinder);
	}
}
