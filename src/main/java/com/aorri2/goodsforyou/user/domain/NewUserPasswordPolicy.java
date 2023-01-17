package com.aorri2.goodsforyou.user.domain;

public class NewUserPasswordPolicy implements UserPolicy {
	@Override
	public void apply(User user) {
		if (user.password().length() <= 8) {
			throw new RuntimeException("패스워드는 8자리 이상 입니다.");
		}
	}
}
