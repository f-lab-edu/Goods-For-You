package com.aorri2.goodsforyou.user.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.policy.NewUserEmailPolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserNamePolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserPasswordPolicy;

@Configuration
public class NewUserPolicyConfig {

	@Bean
	public NewUserEmailPolicy newUserEmailPolicy(UserFinder userFinder) {
		return new NewUserEmailPolicy(userFinder);
	}

	@Bean
	public NewUserNamePolicy newUserNamePolicy(UserFinder userFinder) {
		return new NewUserNamePolicy(userFinder);
	}

	@Bean
	public NewUserPasswordPolicy newUserPasswordPolicy() {
		return new NewUserPasswordPolicy();
	}
}
