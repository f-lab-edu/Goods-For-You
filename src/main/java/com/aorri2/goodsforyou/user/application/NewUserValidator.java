package com.aorri2.goodsforyou.user.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;
import com.aorri2.goodsforyou.user.domain.LoginUserPolicy;
import com.aorri2.goodsforyou.user.domain.UserPolicy;
import com.aorri2.goodsforyou.user.domain.UserValidator;

@Component
public class NewUserValidator implements UserValidator {
	private final List<UserPolicy> validityPolicyList;
	private final List<LoginUserPolicy> loginUserPolicyList;

	public NewUserValidator(List<UserPolicy> validityPolicyList,
		List<LoginUserPolicy> loginUserPolicyList) {
		this.validityPolicyList = validityPolicyList;
		this.loginUserPolicyList = loginUserPolicyList;
	}

	@Override
	public void checkUserValidity(CreateUserCommand user) {
		validityPolicyList.forEach(policy -> policy.apply(user.toEntity()));
	}

	@Override
	public void checkLoginUserValidity(LoginUserCommand command) {
		loginUserPolicyList.forEach(policy -> policy.apply(command));
	}
}
