package com.aorri2.goodsforyou.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.aorri2.goodsforyou.common.validator.GfyEmailValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = GfyEmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GfyEmailConstraint {
	String message() default "일치하지 않는 이메일 형식 입니다.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
