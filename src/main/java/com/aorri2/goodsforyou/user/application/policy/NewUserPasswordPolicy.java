package com.aorri2.goodsforyou.user.application.policy;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.domain.NewUserPolicy;
import com.aorri2.goodsforyou.user.domain.exception.InvalidPasswordException;

public class NewUserPasswordPolicy implements NewUserPolicy {
	@Override
	public void apply(CreateUserCommand command) {
		if (command.getPassword().length() <= 8) {
			throw new InvalidPasswordException();
		}
	}
}
