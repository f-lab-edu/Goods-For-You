package com.aorri2.goodsforyou.user.presentation.request;

import com.aorri2.goodsforyou.common.annotation.GfyEmailConstraint;
import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewUserRequest {

	/**
	 * 커스텀 이메일 검증 애노테이션을 통해 @Email에서는 null값을 허용하지만,
	 * @GfyEmailConstraint 에너테이션을 통해 Null값, 빈 문자열, 공백 문자열을 모두 검증했습니다.
	 * (@NotBlank + @Email)
	 */
	@GfyEmailConstraint
	private String email;

	@NotBlank(message = "이름은 필수 값 입니다.")
	private String name;

	@NotBlank(message = "패스워드는 필수 값 입니다.")
	@Size(min = 8, message = "패스워드는 최소 8 글자 이상이여야 합니다.")
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

