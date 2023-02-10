package com.aorri2.goodsforyou.user.presentation.request;

import com.aorri2.goodsforyou.common.annotation.GfyEmailConstraint;
import com.aorri2.goodsforyou.user.application.command.LoginUserCommand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUserRequest {

	@GfyEmailConstraint
	private String email;

	@NotBlank(message = "패스워드는 필수 값 입니다.")
	@Size(min = 8, message = "패스워드는 최소 8 글자 이상이여야 합니다.")
	private String password;

	public LoginUserRequest() {
	}

	public LoginUserRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public LoginUserCommand toCommand() {
		return new LoginUserCommand(this.email, this.password);
	}
}
