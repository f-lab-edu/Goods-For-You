package com.aorri2.goodsforyou.user.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aorri2.goodsforyou.user.application.UserManagement;
import com.aorri2.goodsforyou.user.presentation.request.NewUserRequest;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private final UserManagement userManagement;

	public UserController(UserManagement userManagement) {
		this.userManagement = userManagement;
	}

	@PostMapping("/users")
	public ResponseEntity<NewUserRequest> register(@RequestBody NewUserRequest request) {
		userManagement.joinUser(request.toCommand());

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
