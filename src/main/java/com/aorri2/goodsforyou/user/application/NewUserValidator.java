package com.aorri2.goodsforyou.user.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;
import com.aorri2.goodsforyou.user.domain.LoginUserPolicy;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserPolicy;
import com.aorri2.goodsforyou.user.domain.UserValidator;
import com.aorri2.goodsforyou.user.domain.policy.LoginUserEmailPolicy;
import com.aorri2.goodsforyou.user.domain.policy.LoginUserPasswordPolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserEmailPolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserNamePolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserPasswordPolicy;

@Component
public class NewUserValidator implements UserValidator {
	private final List<UserPolicy> validityPolicyList;
	private final List<LoginUserPolicy> loginUserPolicyList;

	public NewUserValidator(UserFinder userFinder) {
		this.validityPolicyList = List.of(new NewUserEmailPolicy(userFinder), new NewUserNamePolicy(userFinder),
			new NewUserPasswordPolicy());
		this.loginUserPolicyList = List.of(new LoginUserEmailPolicy(userFinder),
			new LoginUserPasswordPolicy(userFinder));
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
