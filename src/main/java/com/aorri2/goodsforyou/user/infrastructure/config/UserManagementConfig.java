package com.aorri2.goodsforyou.user.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aorri2.goodsforyou.user.application.UserManagement;
import com.aorri2.goodsforyou.user.application.auth.AuthService;
import com.aorri2.goodsforyou.user.application.facade.NewUserManagement;
import com.aorri2.goodsforyou.user.domain.PasswordEncoder;
import com.aorri2.goodsforyou.user.domain.TokenGenerator;
import com.aorri2.goodsforyou.user.domain.UserCreator;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserValidator;
import com.aorri2.goodsforyou.user.infrastructure.encrypt.BcryptPasswordEncoder;

@Configuration
public class UserManagementConfig {

	@Bean
	public UserManagement userManagement(UserCreator userCreator,
		UserValidator userValidator, TokenGenerator tokenGenerator,
		AuthService authService, PasswordEncoder passwordEncoder,
		UserFinder userFinder) {
		return new NewUserManagement(userCreator, userValidator, tokenGenerator, authService, passwordEncoder,
			userFinder);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BcryptPasswordEncoder();
	}
}
