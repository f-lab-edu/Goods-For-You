package com.aorri2.goodsforyou.user.application.command;

import com.aorri2.goodsforyou.user.domain.NewUser;
import com.aorri2.goodsforyou.user.domain.User;

public class CreateUserCommand {

	private String email;
	private String name;
	private String password;

	public CreateUserCommand(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public User toEntity() {
		return new NewUser(this.email, this.name, this.password);
	}

}
