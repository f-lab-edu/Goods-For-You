package com.aorri2.goodsforyou.user.domain.policy;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserPolicy;
import com.aorri2.goodsforyou.user.domain.exception.InvalidPasswordException;

@Component
public class NewUserPasswordPolicy implements UserPolicy {
	@Override
	public void apply(User user) {
		if (user.password().length() <= 8) {
			throw new InvalidPasswordException();
		}
	}
}
