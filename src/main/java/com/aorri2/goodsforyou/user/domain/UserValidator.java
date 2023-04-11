package com.aorri2.goodsforyou.user.domain;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;

public interface UserValidator {
	void checkUserValidity(CreateUserCommand user);

	void checkLoginUserValidity(LoginUserCommand command);
}
