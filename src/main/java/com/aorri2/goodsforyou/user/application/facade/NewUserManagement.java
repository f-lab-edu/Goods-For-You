package com.aorri2.goodsforyou.user.application.facade;

import org.springframework.stereotype.Service;

import com.aorri2.goodsforyou.user.application.UserManagement;
import com.aorri2.goodsforyou.user.application.auth.AuthService;
import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;
import com.aorri2.goodsforyou.user.domain.TokenGenerator;
import com.aorri2.goodsforyou.user.domain.UserCreator;
import com.aorri2.goodsforyou.user.domain.UserValidator;

@Service
public class NewUserManagement implements UserManagement {

	private final UserCreator userCreator;
	private final UserValidator userValidator;
	private final TokenGenerator tokenGenerator;

	private final AuthService authService;

	public NewUserManagement(UserCreator userCreator, UserValidator userValidator, TokenGenerator tokenGenerator,
		AuthService authService) {
		this.userCreator = userCreator;
		this.userValidator = userValidator;
		this.tokenGenerator = tokenGenerator;
		this.authService = authService;
	}

	@Override
	public void joinUser(CreateUserCommand command) {
		userValidator.checkUserValidity(command);
		userCreator.save(command.toEntity());
	}

	@Override
	public String loginUser(LoginUserCommand command) {
		userValidator.checkLoginUserValidity(command);
		String token = tokenGenerator.generate();
		authService.login(token);
		return token;
	}

	@Override
	public void logout() {
		authService.logout();
	}

}
