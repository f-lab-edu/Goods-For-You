package com.aorri2.goodsforyou.utils;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.session.MapSession;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.SessionRepository;
import org.springframework.session.web.http.SessionRepositoryFilter;

@TestConfiguration
public class DefaultSessionConfig {

	@Bean
	public SessionRepositoryFilter<MapSession> sessionRepositoryFilter(
		SessionRepository<MapSession> sessionRepository) {
		SessionRepositoryFilter<MapSession> sessionRepositoryFilter = new SessionRepositoryFilter<>(sessionRepository);
		return sessionRepositoryFilter;
	}

	@Bean
	public SessionRepository<MapSession> sessionRepository() {
		MapSessionRepository sessionRepository = new MapSessionRepository(new ConcurrentHashMap<>());
		return sessionRepository;
	}
}
