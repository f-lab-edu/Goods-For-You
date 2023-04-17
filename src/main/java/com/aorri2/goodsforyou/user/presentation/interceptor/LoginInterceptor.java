package com.aorri2.goodsforyou.user.presentation.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.aorri2.goodsforyou.common.annotation.LoginCheck;
import com.aorri2.goodsforyou.user.domain.exception.UnAuthorizedUserAccessException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

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
