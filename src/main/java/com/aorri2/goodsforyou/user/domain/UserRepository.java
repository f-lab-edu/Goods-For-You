package com.aorri2.goodsforyou.user.domain;

public interface UserRepository {

	void save(User user);

	User findByName(String name);

	User findByEmail(String email);
	
}
