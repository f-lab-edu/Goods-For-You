package com.aorri2.goodsforyou.user.infrastructure.inmemory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.user.domain.User;

@Component
public class MemoryUserRepository {

	private static Map<Long, User> userStore = new ConcurrentHashMap<>();
	private static AtomicLong userIdSequence = new AtomicLong();

	public void save(User user) {
		long currentId = userIdSequence.incrementAndGet();
		userStore.put(currentId, user);
	}

	public User findByName(String name) {
		return userStore.values().stream()
			.filter(user -> user.name().equals(name))
			.findFirst()
			.orElse(null);
	}

	public User findByEmail(String email) {
		return userStore.values().stream()
			.filter(user -> user.email().equals(email))
			.findFirst()
			.orElse(null);
	}

	public void clear() {
		userStore.clear();
	}
}
