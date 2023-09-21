package com.aorri2.goodsforyou.user.infrastructure.jpa;

import org.springframework.stereotype.Repository;

import com.aorri2.goodsforyou.common.annotation.ElapsedTime;
import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserRepositoryPort;

@Repository
@ElapsedTime
public class UserJpaAdapter implements UserRepositoryPort {

	private final UserJpaRepository userJpaRepository;

	public UserJpaAdapter(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}

	@Override
	public void save(User user) {
		userJpaRepository.save(user);
	}

	@Override
	public User findByName(String name) {
		return userJpaRepository.findByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return userJpaRepository.findByEmail(email);
	}
}
