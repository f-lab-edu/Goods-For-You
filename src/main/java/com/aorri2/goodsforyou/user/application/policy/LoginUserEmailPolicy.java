package com.aorri2.goodsforyou.user.application.policy;

import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;
import com.aorri2.goodsforyou.user.domain.LoginUserPolicy;
import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;

public class LoginUserEmailPolicy implements LoginUserPolicy {

	private final UserFinder userFinder;

	public LoginUserEmailPolicy(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	@Override
	public void apply(LoginUserCommand loginUserCommand) {
		User foundByEmail = userFinder.findByEmail(loginUserCommand.getEmail());

		if (foundByEmail == null) {
			throw new RuntimeException("유효하지 않은 회원 이메일 입니다.");
		}

	}
}
