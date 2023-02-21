package com.aorri2.goodsforyou.user.application.policy;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserPolicy;
import com.aorri2.goodsforyou.user.domain.exception.DuplicatedEmailException;

public class NewUserEmailPolicy implements UserPolicy {

	private final UserFinder userFinder;

	public NewUserEmailPolicy(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	@Override
	public void apply(User user) {
		if (userFinder.findByEmail(user.email()) != null) {
			throw new DuplicatedEmailException();
		}
	}
}