package com.aorri2.goodsforyou.user.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aorri2.goodsforyou.user.domain.UserRepositoryPort;
import com.aorri2.goodsforyou.user.infrastructure.UserRepositoryAdapter;
import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepository;

@Configuration
public class UserRepositoryConfig {

	@Bean
	public UserRepositoryPort userRepository(MemoryUserRepository memoryUserRepository) {
		return new UserRepositoryAdapter(memoryUserRepository);
	}
}
