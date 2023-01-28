package com.aorri2.goodsforyou.user.presentation.request;

import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;

public class NewUserRequest {

	private String email;

	private String name;

	private String password;

	public NewUserRequest() {
	}

	public NewUserRequest(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public CreateUserCommand toCommand() {
		return new CreateUserCommand(email, name, password);
	}
}

