package com.aorri2.goodsforyou.user.domain;

public class NewUserNamePolicy implements UserPolicy {
	private final UserFinder userFinder;

	public NewUserNamePolicy(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	@Override
	public void apply(User user) {
		if (userFinder.findByName(user.name()) != null) {
			throw new RuntimeException("이미 존재하는 닉네임 입니다.");
		}
	}
}
