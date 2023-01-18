package com.aorri2.goodsforyou.user.domain.policy;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserPolicy;

public class NewUserPasswordPolicy implements UserPolicy {
	@Override
	public void apply(User user) {
		if (user.password().length() <= 8) {
			throw new RuntimeException("패스워드는 8자리 이상 입니다.");
		}
	}
}
