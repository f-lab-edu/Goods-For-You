package com.aorri2.goodsforyou.transaction.domain;

public interface Policy<T> {
	void apply(T t);
}
