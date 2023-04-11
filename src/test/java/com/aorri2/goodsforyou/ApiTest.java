package com.aorri2.goodsforyou;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;

/**
 * webEnvironment 속성은 테스트의 웹 환경을 설정하는 속성입니다. 기본값은 WebEnvironment.MOCK입니다.
 * RANDOM_PORT로 설정하면 스프링 부트의 내장 서버를 랜덤 포트로 설정합니다.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}
}
