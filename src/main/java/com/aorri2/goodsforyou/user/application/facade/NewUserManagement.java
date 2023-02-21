package com.aorri2.goodsforyou.user.application.facade;

import com.aorri2.goodsforyou.user.application.UserManagement;
import com.aorri2.goodsforyou.user.application.auth.AuthService;
import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;
import com.aorri2.goodsforyou.user.domain.PasswordEncoder;
import com.aorri2.goodsforyou.user.domain.TokenGenerator;
import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserCreator;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserValidator;

public class NewUserManagement implements UserManagement {

	private final UserCreator userCreator;
	private final UserValidator userValidator;
	private final TokenGenerator tokenGenerator;

	private final AuthService authService;
	private final PasswordEncoder passwordEncoder;
	private final UserFinder userFinder;

	public NewUserManagement(UserCreator userCreator, UserValidator userValidator, TokenGenerator tokenGenerator,
		AuthService authService, PasswordEncoder passwordEncoder,
		UserFinder userFinder) {
		this.userCreator = userCreator;
		this.userValidator = userValidator;
		this.tokenGenerator = tokenGenerator;
		this.authService = authService;
		this.passwordEncoder = passwordEncoder;
		this.userFinder = userFinder;
	}

	@Override
	public void joinUser(CreateUserCommand command) {
		userValidator.checkUserValidity(command);
		userCreator.save(getEncryptedCreateUserCommand(command).toEntity());
	}

	@Override
	public String loginUser(LoginUserCommand command) {
		userValidator.checkLoginUserValidity(command);
		checkPasswordValid(command);
		String token = tokenGenerator.generate();
		authService.login(token);
		return token;
	}

	@Override
	public void logout() {
		authService.logout();
	}

	private CreateUserCommand getEncryptedCreateUserCommand(CreateUserCommand command) {
		return new CreateUserCommand(command.getEmail(), command.getName(),
			passwordEncoder.encrypt(command.getPassword()));
	}

	private void checkPasswordValid(LoginUserCommand loginUserCommand) {

		User foundByEmail = userFinder.findByEmail(loginUserCommand.getEmail());

		if (foundByEmail != null && !isPasswordValid(loginUserCommand, foundByEmail)) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
	}

	private boolean isPasswordValid(LoginUserCommand loginUserCommand, User foundUser) {
		return passwordEncoder.match(loginUserCommand.getPassword(), foundUser.password());
	}
}
