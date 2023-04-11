package com.aorri2.goodsforyou.user.application;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserFinderPort;

@Component
public class NewUserFinder implements UserFinder {

	private final UserFinderPort userFinderPort;

	public NewUserFinder(UserFinderPort userFinderPort) {
		this.userFinderPort = userFinderPort;
	}

	@Override
	public User findByName(String name) {
		return userFinderPort.findByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return userFinderPort.findByEmail(email);
	}
}
