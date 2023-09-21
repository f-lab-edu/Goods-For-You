package com.aorri2.goodsforyou.user.infrastructure.jpa;

import org.springframework.data.repository.Repository;

import com.aorri2.goodsforyou.user.domain.NewUser;
import com.aorri2.goodsforyou.user.domain.User;

public interface UserJpaRepository extends Repository<NewUser, Long> {
	void save(User user);

	User findByName(String name);

	User findByEmail(String email);
}
