package com.aorri2.goodsforyou.user.application;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;

public interface UserManagement {
	void joinUser(CreateUserCommand command);
}
