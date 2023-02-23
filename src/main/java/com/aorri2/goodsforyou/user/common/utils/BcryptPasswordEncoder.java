package com.aorri2.goodsforyou.user.common.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Password 암호화를 위한 Util 클래스 입니다.
 *
 */
public class BcryptPasswordEncoder {

	/*
	기본 생성자를 private 생성자로 변경함으로써, BcryptPasswordEncoder 클래스를
	extend해, 확장 하거나 변경이 불가능 하도록 했습니다.
	 */
	private BcryptPasswordEncoder() {
	}

	public static String encrypt(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static boolean match(String password, String encryptedPassword) {
		return BCrypt.checkpw(password, encryptedPassword);
	}
}

/*
사용하고자 하는 패스워드 암호화의 종류로 SHA-2 방식과, Bcrypt 방식을 생각했었습니다.
먼저 SHA-2 방식은 GPU를 이용해, 복호화를 할시, 연산 속도가 매우 빠르기 때문에 악의를 품은 해커의 하드웨어를 통한 Brute Force 공격에 취약하다는 단점이 있습니다.
(SHA는 일반적으로 GPU연산에 유리한 32비트 논리 및 산술 연산만 사용하기 때문에, 공격자가 빠른연산으로 공격할 수 있기 때문에 암호화 함수로 추천되지 않습니다.)
반면 Bcrypt 방식은, Blowfish 암호를 기반으로 설계 된, 암호화 함수입니다. BCrpyt는 SHA와 달리 Salt라는 값을 암호화 과정에 추가 해 암호 해독을 위한 반복횟수를 늘려, 연산 속도를 늦출 수 있으므로 공격자의 연산 능력이 증가하더라도
brute-force 공격에 대비할 수 있다는 장점이 있습니다.

- 만약 SHA-2 방식과 같이 Hash함수를 통해 암호화된 비밀번호를, 공격자가 레인보우 테이블(레인보우 테이블은 해시 함수(MD5, SHA-1, SHA-2 등)을 사용하여 만들어낼 수 있는 값들을 저장한 표)
  통해 브루트 포스 공격을 한다면, 공격자의 GPU 연산 능력에 따라 비밀번호가 유출될 가능성이 높을 것 입니다.
  반면에 Bcrypt 방식을 통해 Hash함수 + Salt(데이터, 비밀번호, 통과암호를 해시 처리하는 단방향 함수의 추가 입력으로 사용되는 랜덤 데이터이다.)로 	비밀번호 암호화를 진행한다면
  공격자의 레인보우 테이블을 통한 브루트 포스 공격에도, 대비할 수 있다고 생각해 현재 프로젝트에서는 Bcrypt함수를 선택 했습니다.
 */