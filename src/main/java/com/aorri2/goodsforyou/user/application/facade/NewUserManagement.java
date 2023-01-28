package com.aorri2.goodsforyou.user.application.facade;

import org.springframework.stereotype.Service;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.domain.UserCreator;
import com.aorri2.goodsforyou.user.application.UserManagement;
import com.aorri2.goodsforyou.user.domain.UserValidator;

@Service
public class NewUserManagement implements UserManagement {

	private final UserCreator userCreator;
	private final UserValidator userValidator;

	public NewUserManagement(UserCreator userCreator, UserValidator userValidator) {
		this.userCreator = userCreator;
		this.userValidator = userValidator;
	}

	@Override
	public void joinUser(CreateUserCommand command) {
		userValidator.checkUserValidity(command);
		userCreator.save(command.toEntity());
	}
}
