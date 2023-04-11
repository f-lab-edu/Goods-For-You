package com.aorri2.goodsforyou.user.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;
import com.aorri2.goodsforyou.user.domain.LoginUserPolicy;
import com.aorri2.goodsforyou.user.domain.NewUserPolicy;
import com.aorri2.goodsforyou.user.domain.UserValidator;

@Component
public class NewUserValidator implements UserValidator {
	private final List<NewUserPolicy> validityPolicyList;
	private final List<LoginUserPolicy> loginUserPolicyList;

	public NewUserValidator(List<NewUserPolicy> validityPolicyList,
		List<LoginUserPolicy> loginUserPolicyList) {
		this.validityPolicyList = validityPolicyList;
		this.loginUserPolicyList = loginUserPolicyList;
	}

	@Override
	public void checkUserValidity(CreateUserCommand createUserCommand) {
		validityPolicyList.forEach(policy -> policy.apply(createUserCommand));
	}

	@Override
	public void checkLoginUserValidity(LoginUserCommand command) {
		loginUserPolicyList.forEach(policy -> policy.apply(command));
	}
}
