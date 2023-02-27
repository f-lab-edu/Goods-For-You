package com.aorri2.goodsforyou.user.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aorri2.goodsforyou.user.application.policy.LoginUserEmailPolicy;
import com.aorri2.goodsforyou.user.application.policy.LoginUserPasswordPolicy;
import com.aorri2.goodsforyou.user.domain.UserFinder;

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
