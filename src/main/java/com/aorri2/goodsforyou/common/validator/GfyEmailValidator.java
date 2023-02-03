package com.aorri2.goodsforyou.common.validator;

import org.springframework.util.StringUtils;

import com.aorri2.goodsforyou.common.annotation.GfyEmailConstraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GfyEmailValidator implements ConstraintValidator<GfyEmailConstraint, String> {
	@Override
	public void initialize(GfyEmailConstraint constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	/**
	 *
	 * StringUtils 클래스의 hasText 메서드를 이용해 문자열이 null이 아니여야 하며, 문자열이 빈값("")이 아니여야 하고, 문자열이 공백이 없어야 한다(" ")
	 * 는 조건을 추가했습니다.
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return StringUtils.hasText(value) && value.matches(
			"^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
	}
}
