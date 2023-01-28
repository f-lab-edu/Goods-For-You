package com.aorri2.goodsforyou.user.domain;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;

public interface UserValidator {
	void checkUserValidity(CreateUserCommand user);
}
