package com.aorri2.goodsforyou.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.aorri2.goodsforyou.user.presentation.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MDCLogginInterceptor());
		registry.addInterceptor(new LoginInterceptor());
	}
}
