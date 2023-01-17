package com.aorri2.goodsforyou.user.domain;

public class NewUserManagement implements UserManagement {

	private final UserCreator userCreator;
	private final UserValidator userValidator;

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
