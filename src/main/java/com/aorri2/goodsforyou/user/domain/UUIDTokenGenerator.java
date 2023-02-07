package com.aorri2.goodsforyou.user.domain;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UUIDTokenGenerator implements TokenGenerator {
	@Override
	public String generate() {
		return UUID.randomUUID().toString();
	}
}
