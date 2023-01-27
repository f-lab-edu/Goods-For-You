package com.aorri2.goodsforyou.user.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserPolicy;
import com.aorri2.goodsforyou.user.domain.UserValidator;
import com.aorri2.goodsforyou.user.domain.policy.NewUserEmailPolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserNamePolicy;
import com.aorri2.goodsforyou.user.domain.policy.NewUserPasswordPolicy;

@Component
public class NewUserValidator implements UserValidator {
	private final List<UserPolicy> validityPolicyList;

	public NewUserValidator(UserFinder userFinder) {
		this.validityPolicyList = List.of(new NewUserEmailPolicy(userFinder), new NewUserNamePolicy(userFinder),
			new NewUserPasswordPolicy());
	}

	@Override
	public void checkUserValidity(User user) {
		validityPolicyList.forEach(policy -> policy.apply(user));
	}
}
