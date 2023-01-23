package com.aorri2.goodsforyou.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewUserCreator implements UserCreator {
	private final UserRepository userRepository;

	@Autowired
	public NewUserCreator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}
}
