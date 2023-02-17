package com.aorri2.goodsforyou.user.infrastructure.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.aorri2.goodsforyou.user.domain.User;

@Mapper
public interface MybatisUserMapper {

	void save(User user);

	User findByName(String name);

	User findByEmail(String email);
}
