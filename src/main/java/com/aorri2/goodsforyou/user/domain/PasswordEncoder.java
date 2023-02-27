package com.aorri2.goodsforyou.user.domain;

public interface PasswordEncoder {
	String encrypt(String password);

	boolean match(String password, String encryptedPassword);
}
