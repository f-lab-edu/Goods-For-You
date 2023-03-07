package com.aorri2.goodsforyou.user.domain;

public interface Policy<T> {
	void apply(T t);
}
