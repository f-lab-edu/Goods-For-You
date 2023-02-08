package com.aorri2.goodsforyou.user.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.policy.LoginUserEmailPolicy;
import com.aorri2.goodsforyou.user.domain.policy.LoginUserPasswordPolicy;

@Configuration
public class LoginUserPolicyConfig {

	@Bean
	public LoginUserEmailPolicy loginUserEmailPolicy(UserFinder userFinder) {
		return new LoginUserEmailPolicy(userFinder);
	}

	@Bean
	public LoginUserPasswordPolicy loginUserPasswordPolicy(UserFinder userFinder) {
		return new LoginUserPasswordPolicy(userFinder);
	}
}
