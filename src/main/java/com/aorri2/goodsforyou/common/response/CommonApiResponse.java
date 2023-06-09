package com.aorri2.goodsforyou.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonApiResponse<T> {
	private String resultCode;
	private T result;

	public static <T> CommonApiResponse<T> success() {
		return new CommonApiResponse<T>("SUCCESS", null);
	}

	public static <T> CommonApiResponse<T> success(T result) {
		return new CommonApiResponse<>("SUCCESS", result);
	}
}
