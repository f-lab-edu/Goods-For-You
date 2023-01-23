package com.aorri2.goodsforyou.user.domain;

import org.springframework.stereotype.Component;

@Component
public class NewUserFinder implements UserFinder {

	private final UserRepositoryPort userRepositoryPort;

	public NewUserFinder(UserRepositoryPort userRepositoryPort) {
		this.userRepositoryPort = userRepositoryPort;
	}

	@Override
	public User findByName(String name) {
		return userRepositoryPort.findByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return userRepositoryPort.findByEmail(email);
	}
}
