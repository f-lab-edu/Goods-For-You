package com.aorri2.goodsforyou.user.domain;

import com.aorri2.goodsforyou.common.utils.BcryptPasswordEncoder;

public class NewUser implements User {
	private Long id;
	private final String email;
	private final String name;
	private final String password;

	public NewUser(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = encryptedPassword(password);
	}

	@Override
	public Long id() {
		return id;
	}

	@Override
	public String email() {
		return email;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String password() {
		return password;
	}

	/**
	 * @param password 암호화 되지 않은 평문의 패스워드
	 * @return Bcrypt를 이용해 암호화가 완료된 패스워드
	 */
	private String encryptedPassword(String password) {
		return BcryptPasswordEncoder.encrypt(password);
	}
}
