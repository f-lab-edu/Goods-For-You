package com.aorri2.goodsforyou.user.application.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserCreator;
import com.aorri2.goodsforyou.user.domain.UserManagement;
import com.aorri2.goodsforyou.user.domain.UserValidator;

@Component
public class NewUserManagement implements UserManagement {

	private final UserCreator userCreator;
	private final UserValidator userValidator;

	@Autowired
	public NewUserManagement(UserCreator userCreator, UserValidator userValidator) {
		this.userCreator = userCreator;
		this.userValidator = userValidator;
	}

	@Override
	public void joinUser(User user) {
		userValidator.checkUserValidity(user);
		userCreator.save(user);
	}
}
