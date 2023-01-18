package com.aorri2.goodsforyou.user.domain.policy;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserFinder;
import com.aorri2.goodsforyou.user.domain.UserPolicy;

public class NewUserEmailPolicy implements UserPolicy {

	private final UserFinder userFinder;

	public NewUserEmailPolicy(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	@Override
	public void apply(User user) {
		if (userFinder.findByEmail(user.email()) != null) {
			throw new RuntimeException("이미 존재하는 이메일 입니다.");
		}
	}
}