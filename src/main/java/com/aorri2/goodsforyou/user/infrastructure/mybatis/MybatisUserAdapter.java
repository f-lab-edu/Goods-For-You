package com.aorri2.goodsforyou.user.infrastructure.mybatis;

import com.aorri2.goodsforyou.user.domain.User;
import com.aorri2.goodsforyou.user.domain.UserRepositoryPort;

public class MybatisUserAdapter implements UserRepositoryPort {

	private final MybatisUserMapper mapper;

	public MybatisUserAdapter(MybatisUserMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void save(User user) {
		mapper.save(user);
	}

	@Override
	public User findByName(String name) {
		return mapper.findByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return mapper.findByEmail(email);
	}
}
