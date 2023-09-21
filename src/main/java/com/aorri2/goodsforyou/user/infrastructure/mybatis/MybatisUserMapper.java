package com.aorri2.goodsforyou.user.infrastructure.mybatis;

import com.aorri2.goodsforyou.user.domain.User;

public interface MybatisUserMapper {

	void save(User user);

	User findByName(String name);

	User findByEmail(String email);
}
