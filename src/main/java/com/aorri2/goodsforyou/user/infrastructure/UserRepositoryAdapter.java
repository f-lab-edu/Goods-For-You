package com.aorri2.goodsforyou.user.infrastructure;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserRepositoryPort;
import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepository;

public class UserRepositoryAdapter implements UserRepositoryPort {

	private final MemoryUserRepository userRepository;

	public UserRepositoryAdapter(
		MemoryUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void save(User user) {
		this.userRepository.save(user);
	}

	@Override
	public User findByName(String name) {
		return this.userRepository.findByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
}
