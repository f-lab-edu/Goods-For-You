package com.aorri2.goodsforyou.user.domain;

import org.springframework.stereotype.Component;

@Component
public class NewUserFinder implements UserFinder {

	private final UserRepository userRepository;

	public NewUserFinder(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
