package com.aorri2.goodsforyou.common.aspect;

import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ElapsedTimeAspect {

	@Around("@within(com.aorri2.goodsforyou.common.annotation.ElapsedTime))")
	public Object logElapsedTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.nanoTime();
		Object result = joinPoint.proceed();
		long elapsedTime = (System.nanoTime() - startTime) / 1_000_000;
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		ThreadContext.put("elapse_time", String.valueOf(elapsedTime));
		log.info("{}.{}() elapsed time {} ms", className, methodName, elapsedTime);
		ThreadContext.remove("elapse_time");
		return result;
	}
}
