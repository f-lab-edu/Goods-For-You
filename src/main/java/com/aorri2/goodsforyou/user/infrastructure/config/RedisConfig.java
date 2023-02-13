package com.aorri2.goodsforyou.user.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
		return new GenericJackson2JsonRedisSerializer();
	}

}

/*
 * RedisSerializer - Byte 배열(이진 데이터)에 대한 직렬화와 역직렬화시에 기본 인터페이스 입니다.
 * GenericJackson2JsonRedisSerializer - Generic Jackson 2 기반의 Redis에서 사용 가능한 동적 타이핑을 통해
 * 										객체를 JSON에 매핑해주는 Serializer입니다.
 *
 * Serializer를 사용하는 이유? - Spring FrameWork 관점에서 Redis에 저장된 데이터는 바이트일 뿐입니다.
 * 							  따라서 사용자는 바이트로 이루어진 데이터를 string이나 object로 가져올지 선택해야 하는데 그 과정에서 Serializer가 필요합니다.
 *
 */