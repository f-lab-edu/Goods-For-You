package com.aorri2.goodsforyou.user.domain;

import com.aorri2.goodsforyou.common.utils.BcryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER")
public class NewUser implements User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;

	protected NewUser() {

	}

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
