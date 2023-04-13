package com.aorri2.goodsforyou.common.interceptor;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MDCLogginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) throws Exception {
		ContentCachingResponseWrapper responseWrapper = getResponseWrapper(response);
		int status = responseWrapper.getStatus();
		log.info("statusCode in Interceptor = {}", status);
		MDC.put("status_code", Integer.toString(status));
	}

	private ContentCachingResponseWrapper getResponseWrapper(HttpServletResponse response) {
		if (response instanceof ContentCachingResponseWrapper) {
			return (ContentCachingResponseWrapper)response;
		}
		return new ContentCachingResponseWrapper(response);
	}
}
