package com.aorri2.goodsforyou.user.domain;

import java.util.Collections;
import java.util.List;

public class NewUserValidator implements UserValidator {
	List<UserPolicy> validityPolicyList = Collections.emptyList();

	@Override
	public void checkUserValidity(User user) {
		validityPolicyList.forEach(policy -> policy.apply(user));
	}
}
