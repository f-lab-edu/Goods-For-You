package com.aorri2.goodsforyou.transaction.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aorri2.goodsforyou.product.domain.ProductFinder;
import com.aorri2.goodsforyou.transaction.application.policy.RegisterTransactionProductStatusPolicy;

@Configuration
public class RegisterTransactionPolicyConfig {

	@Bean
	public RegisterTransactionProductStatusPolicy registerTransactionProductStatusPolicy(ProductFinder productFinder) {
		return new RegisterTransactionProductStatusPolicy(productFinder);
	}
}
