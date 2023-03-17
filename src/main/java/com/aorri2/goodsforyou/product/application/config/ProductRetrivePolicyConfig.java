package com.aorri2.goodsforyou.product.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aorri2.goodsforyou.product.application.policy.ProductRetriveByIdPolicy;

@Configuration
public class ProductRetrivePolicyConfig {

	@Bean
	public ProductRetriveByIdPolicy productRetriveByIdPolicy() {
		return new ProductRetriveByIdPolicy();
	}
}
