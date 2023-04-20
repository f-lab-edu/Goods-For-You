package com.aorri2.goodsforyou.user.presentation.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.aorri2.goodsforyou.common.annotation.LoginCheck;
import com.aorri2.goodsforyou.user.domain.exception.UnAuthorizedUserAccessException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 사용자 로그인 시, 로그인 여부를 확인하는 토큰을 저장한 세션의 key 를 나타내는 상수
	 */
	private static final String SESSION_ID = "sessionId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		String sessionId = (String)request.getSession().getAttribute(SESSION_ID);

		if (handlerMethod.hasMethodAnnotation(LoginCheck.class) && sessionId == null) {
			throw new UnAuthorizedUserAccessException();
		}

		return true;
	}
}
