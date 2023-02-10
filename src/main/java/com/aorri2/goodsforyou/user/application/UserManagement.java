package com.aorri2.goodsforyou.user.application;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;

public interface UserManagement {
	void joinUser(CreateUserCommand command);

	String loginUser(LoginUserCommand command);
}
