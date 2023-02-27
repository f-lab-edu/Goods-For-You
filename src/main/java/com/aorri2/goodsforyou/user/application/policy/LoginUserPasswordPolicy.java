package com.aorri2.goodsforyou.user.application.policy;

import com.aorri2.goodsforyou.common.utils.BcryptPasswordEncoder;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;
import com.aorri2.goodsforyou.user.domain.LoginUserPolicy;
import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;

public class LoginUserPasswordPolicy implements LoginUserPolicy {

	private final UserFinder userFinder;

	public LoginUserPasswordPolicy(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	@Override
	public void apply(LoginUserCommand loginUserCommand) {
		User foundByEmail = userFinder.findByEmail(loginUserCommand.getEmail());

		if (foundByEmail != null && !isPasswordValid(loginUserCommand, foundByEmail)) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
	}

	private boolean isPasswordValid(LoginUserCommand loginUserCommand, User foundUser) {
		return BcryptPasswordEncoder.match(loginUserCommand.getPassword(), foundUser.password());
	}
}
