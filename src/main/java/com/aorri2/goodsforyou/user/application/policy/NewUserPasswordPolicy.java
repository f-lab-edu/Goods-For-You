package com.aorri2.goodsforyou.user.application.policy;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserPolicy;
import com.aorri2.goodsforyou.user.domain.exception.InvalidPasswordException;

public class NewUserPasswordPolicy implements UserPolicy {
	@Override
	public void apply(User user) {
		if (user.password().length() <= 8) {
			throw new InvalidPasswordException();
		}
	}
}
