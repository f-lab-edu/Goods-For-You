package com.aorri2.goodsforyou.user.domain;

public interface UserFinderPort {
	User findByName(String name);

	User findByEmail(String email);
}
