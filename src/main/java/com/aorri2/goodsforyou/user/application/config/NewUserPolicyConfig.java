package com.aorri2.goodsforyou.user.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aorri2.goodsforyou.user.application.policy.NewUserEmailPolicy;
import com.aorri2.goodsforyou.user.application.policy.NewUserNamePolicy;
import com.aorri2.goodsforyou.user.application.policy.NewUserPasswordPolicy;
import com.aorri2.goodsforyou.user.domain.UserFinder;

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
