package com.aorri2.goodsforyou.user.domain;

public interface UserFinder {
	User findByName(String name);

	User findByEmail(String email);
}
