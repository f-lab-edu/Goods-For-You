package com.aorri2.goodsforyou.common.filter;

import static java.util.UUID.*;

import java.io.IOException;

import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
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

		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest)request);
		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(
			(HttpServletResponse)response);

		MDC.put("request_id", randomUUID().toString());
		long startTime = System.nanoTime();
		chain.doFilter(requestWrapper, responseWrapper);
		long requestElapsedTime = (System.nanoTime() - startTime) / 1_000_000;
		MDC.put("request_elapsed_time", String.valueOf(requestElapsedTime));
		log.info("request elapsed time = {}", requestElapsedTime);
		loggingRequestAndResponse(requestWrapper, responseWrapper);
		responseWrapper.copyBodyToResponse();
		MDC.clear();
	}

	private void loggingRequestAndResponse(ContentCachingRequestWrapper requestWrapper,
		ContentCachingResponseWrapper responseWrapper) {
		String requestBody = new String(requestWrapper.getContentAsByteArray());
		String responseBody = new String(responseWrapper.getContentAsByteArray());

		MDC.put("request_body", requestBody);
		MDC.put("response_body", responseBody);
		log.info("request Body : {}", requestBody);
		log.info("response Body : {}", responseBody);
	}
}
