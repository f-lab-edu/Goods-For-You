package com.aorri2.goodsforyou.common.utils;

import org.slf4j.Logger;

import com.aorri2.goodsforyou.common.domain.ErrorResult;

/**
 * Advice에서 예외 처리시, 남겨지는 예외 로그를 처리하는 Helper 클래스
 */
public class ExceptionLogHelper {

	private ExceptionLogHelper() {
	}

	/**
	 *
	 * @param logger 예외를 처리하는 Advice 객체에서 사용하는 logger를 받아옴
	 * @param e Advice에서 Handling 하고자 지정한 예외
	 * @param result 예외에 대한 정보를 갖고 있는 클래스 {@link ErrorResult} 참고
	 */
	public static void makeExcepetionLog(Logger logger, Exception e, ErrorResult result) {
		logger.error("{} Occurred: error code = {}, message = {}", e.getClass().getSimpleName(),
			result.getCode(), result.getMessage());
	}
}

/*
로그의 형식이 바뀜에 따라 Advice 객체가 바뀔 필요 없이,
ExceptionLogHelper 객체만 수정 되도록 해 코드의 재사용성 및 유지보수성을 늘리고자 해당 클래스를 작성했습니다.
 */