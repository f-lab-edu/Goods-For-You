package com.aorri2.goodsforyou.user.domain.validator;

import java.util.ArrayList;
import java.util.List;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserPolicy;
import com.aorri2.goodsforyou.user.domain.UserValidator;

public class NewUserValidator implements UserValidator {
	List<UserPolicy> validityPolicyList = new ArrayList<>();

	@Override
	public void checkUserValidity(User user) {
		validityPolicyList.forEach(policy -> policy.apply(user));
	}
}
