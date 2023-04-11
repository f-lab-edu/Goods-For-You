package com.aorri2.goodsforyou.trade.domain;

public interface Policy<T> {
	void apply(T t);
}
