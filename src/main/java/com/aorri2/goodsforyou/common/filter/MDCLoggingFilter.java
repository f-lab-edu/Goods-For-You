package com.aorri2.goodsforyou.common.filter;

import static java.util.UUID.*;

import java.io.IOException;

import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class MDCLoggingFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {
		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(
			(HttpServletResponse)response);
		log.info("WrappedResponseStatusInFilter = {}", responseWrapper.getStatus());
		MDC.put("request_id", randomUUID().toString());
		chain.doFilter(request, responseWrapper);
		responseWrapper.copyBodyToResponse();
		MDC.clear();
	}
}
