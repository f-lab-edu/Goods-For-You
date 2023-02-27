package com.aorri2.goodsforyou.user.application.policy;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.domain.NewUserPolicy;
import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.exception.DuplicatedNameException;

public class NewUserNamePolicy implements NewUserPolicy {
	private final UserFinder userFinder;

	public NewUserNamePolicy(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	@Override
	public void apply(CreateUserCommand createUserCommand) {
		User user = createUserCommand.toEntity();
		if (userFinder.findByName(user.name()) != null) {
			throw new DuplicatedNameException();
		}
	}
}
