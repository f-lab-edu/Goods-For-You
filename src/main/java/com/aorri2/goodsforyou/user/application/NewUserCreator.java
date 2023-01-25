package com.aorri2.goodsforyou.user.application;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserCreator;
import com.aorri2.goodsforyou.user.domain.UserCreatorPort;
import com.aorri2.goodsforyou.user.domain.UserRepositoryPort;

@Component
public class NewUserCreator implements UserCreator {
	private final UserCreatorPort userRepositoryPort;

	public NewUserCreator(UserRepositoryPort userRepositoryPort) {
		this.userRepositoryPort = userRepositoryPort;
	}

	@Override
	public void save(User user) {
		userRepositoryPort.save(user);
	}
}
