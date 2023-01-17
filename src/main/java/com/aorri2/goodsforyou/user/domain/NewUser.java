package com.aorri2.goodsforyou.user.domain;

public class NewUser implements User {
	private final String email;
	private final String name;
	private final String password;

	public NewUser(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
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

}
